package com.xu.module.sport.ui.activity.realtime

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.jaeger.library.StatusBarUtil
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.BaseMvpActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.commonlib.utlis.extention.afterMeasured
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.module.sport.R
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
            v_start.visibility = View.VISIBLE
            tv_start.visibility = View.VISIBLE
            sfv_finish_sport.visibility = View.GONE
            Logger.d("解锁成功")
        }

        //开始运动
        v_start.singleClick {
            v_start.visibility = View.GONE
            tv_start.visibility = View.GONE
            sfv_finish_sport.visibility = View.VISIBLE
            Logger.d("开始运动")
        }
    }


    private fun initMap() {
        val uiSetting = mv_real_time.map.uiSettings
        uiSetting.isRotateGesturesEnabled = false
        uiSetting.isTiltGesturesEnabled = false
    }

    override fun onDestroy() {
        super.onDestroy()
        mv_real_time.onDestroy()
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