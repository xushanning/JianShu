package com.xu.module.sport.ui.activity.realtime

import android.Manifest
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.amap.api.maps.model.BitmapDescriptorFactory
import com.amap.api.maps.model.LatLng
import com.amap.api.maps.model.MarkerOptions
import com.amap.api.maps.model.PolylineOptions
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.jaeger.library.StatusBarUtil
import com.jakewharton.rxbinding2.view.RxView
import com.orhanobut.logger.Logger
import com.tbruyelle.rxpermissions2.RxPermissions
import com.xu.commonlib.base.BaseMvpActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.commonlib.utlis.GpsUtil
import com.xu.commonlib.utlis.extention.afterMeasured
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.module.sport.R
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.s_activity_real_time_trajectory.*

/**
 * @author 言吾許
 * 运动实时轨迹界面
 */
@Route(path = ARouterPath.sportRealTimeTrajectory)
class RealTimeTrajectoryActivity :
    BaseMvpActivity<IRealTimeTrajectoryContract.IRealTimeTrajectoryView, IRealTimeTrajectoryContract.IRealTimeTrajectoryPresenter>(),
    IRealTimeTrajectoryContract.IRealTimeTrajectoryView {
    private var originalWidth = 0
    private var originalHeight = 0

    private var lineOptions: PolylineOptions? = null
    private var permissionDis: Disposable? = null


    override fun setLayoutId(): Int {
        return R.layout.s_activity_real_time_trajectory
    }

    override fun setStatusBar() {
        StatusBarUtil.setLightMode(this)
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, android.R.color.transparent), 0)
    }


    override fun initView(savedInstanceState: Bundle?) {


        //获取view的位置
        tv_time.afterMeasured {
            originalWidth = left
            originalHeight = top

            Logger.d(originalHeight)
        }

        mv_real_time.onCreate(savedInstanceState)
        initMap()
        v_back.singleClick {
            jumpToMain()
        }
        sv_bottom_sheet.isNestedScrollingEnabled = false
        //sfv_finish_sport.isNestedScrollingEnabled = false
        //bottom sheet
        val behavior = BottomSheetBehavior.from(sv_bottom_sheet)
        //默认打开
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
        //设置不能下滑彻底消失
        behavior.isHideable = false
        behavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(p0: View, p1: Float) {
                Logger.d(p1)
            }

            override fun onStateChanged(p0: View, p1: Int) {
                //状态改变，重新测量view
                if (p1 == BottomSheetBehavior.STATE_EXPANDED || p1 == BottomSheetBehavior.STATE_COLLAPSED) {
                    originalWidth = tv_time.left
                    originalHeight = tv_time.top
                }

            }

        })
        sfv_finish_sport.setOnLockListener {
            mPresenter.stopSport(this)
        }


        //开始运动
        permissionDis = RxView.clicks(v_start)
            .compose(RxPermissions(this).ensure(Manifest.permission.ACCESS_FINE_LOCATION))
            .subscribe {
                Logger.d(it)
                if (it) {
                    checkGpsOpen()
                } else {
                    //不允许，就不能用此功能

                }
            }


    }

    /**
     * 检查gps是否打开
     */
    private fun checkGpsOpen() {
        if (GpsUtil.isOpen(applicationContext)) {
            mPresenter.startSport(this)
        } else {
            //提示用户打开gps

        }


    }


    private fun initMap() {
        val uiSetting = mv_real_time.map.uiSettings
        uiSetting.isRotateGesturesEnabled = false
        uiSetting.isTiltGesturesEnabled = false
    }

    override fun sportStarted() {
        v_start.visibility = View.GONE
        tv_start.visibility = View.GONE
        sfv_finish_sport.visibility = View.VISIBLE
    }

    override fun sportStopped() {
        v_start.visibility = View.VISIBLE
        tv_start.visibility = View.VISIBLE
        sfv_finish_sport.visibility = View.GONE
        Logger.d("解锁成功")
    }

    override fun displayTrajectory(point: LatLng) {
        if (lineOptions == null) {
            lineOptions = PolylineOptions().width(10f).color(Color.argb(255, 1, 1, 1))
            mv_real_time.map.addPolyline(lineOptions)
            mv_real_time.map.addMarker(
                MarkerOptions().position(point).icon(
                    BitmapDescriptorFactory.fromBitmap(
                        BitmapFactory.decodeResource(resources, R.drawable.s_vector_location)
                    )
                )
            )
        }
        lineOptions?.add(point)
    }

    override fun onDestroy() {
        super.onDestroy()
        mv_real_time.onDestroy()
        permissionDis?.dispose()
    }

    override fun onResume() {
        super.onResume()
        mv_real_time.onResume()
    }

    override fun onPause() {
        super.onPause()
        mv_real_time.onPause()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            jumpToMain()
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun jumpToMain() {
        //转场动画
        val compat = ActivityOptionsCompat.makeCustomAnimation(
            this, R.anim.s_slide_un_move, R.anim.s_slide_top_bottom
        )
        ARouter.getInstance()
            .build(ARouterPath.sportMain)
            .withFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            .withOptionsCompat(compat)
            .navigation(this@RealTimeTrajectoryActivity)
    }
}