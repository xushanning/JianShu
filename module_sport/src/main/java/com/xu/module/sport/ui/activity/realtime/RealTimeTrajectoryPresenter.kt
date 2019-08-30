package com.xu.module.sport.ui.activity.realtime

import android.animation.ValueAnimator
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.view.animation.AlphaAnimation
import androidx.core.content.ContextCompat
import com.amap.api.maps.model.LatLng
import com.amap.api.maps.model.MarkerOptions
import com.amap.api.maps.model.PolylineOptions
import com.orhanobut.logger.Logger
import com.xu.commonlib.mvp.BasePresenter
import com.xu.module.sport.R
import com.xu.module.sport.service.ISportBind
import com.xu.module.sport.service.SportService
import javax.inject.Inject

/**
 * @author 言吾許
 */
class RealTimeTrajectoryPresenter @Inject constructor() :
    BasePresenter<IRealTimeTrajectoryContract.IRealTimeTrajectoryView, IRealTimeTrajectoryContract.IRealTimeTrajectoryModel>(),
    IRealTimeTrajectoryContract.IRealTimeTrajectoryPresenter, SportService.OnLocationChangeListener {
    private var service: ISportBind? = null

    private lateinit var context: Context
    /**
     * 轨迹点集合
     */
    private lateinit var pointList: MutableList<LatLng>

    private var animator: AlphaAnimation? = null

    private var isBindService = false
    /**
     * 运动距离
     */
    private var sportMileage = 0f

    companion object {
        /**
         * 最短有效距离为100米
         */
        private const val SHORTEST_MILEAGE = 100f
    }


    private val connection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            mView.sportStopped()
        }

        override fun onServiceConnected(name: ComponentName?, binder: IBinder?) {
            service = binder as SportService.SportBind
            service?.startSport()
            service?.getSportService()?.setOnLocationChangeListener(this@RealTimeTrajectoryPresenter)
            mView.sportStarted()
        }

    }

    override fun startSport(context: Context) {
        this.context = context
        pointList = ArrayList()
        val intent = Intent(context, SportService::class.java)
        isBindService = context.bindService(intent, connection, Context.BIND_AUTO_CREATE)
    }

    override fun stopSport(context: Context) {
        if (sportMileage < SHORTEST_MILEAGE) {
            //无效
            service?.deleteTooShortTrajectory()
        } else {
            service?.stopSport()
            if (isBindService) {
                context.unbindService(connection)
            }
            isBindService = false
        }
    }

    override fun onLocationChange(
        latestPoint: LatLng,
        lastPoint: LatLng?,
        pause: Boolean,
        speed: Float,
        altitude: Double,
        sportTime: String,
        sportMileage: Float
    ) {
        this.sportMileage = sportMileage
        mView.refreshDashBoard(sportTime, speed.toString())
        mView.latestPoint(latestPoint)
        if (pause) {
            startFlicker()
        } else {
            stopFlicker()
        }
        pointList.add(latestPoint)

        //点平滑移动
        val movePoints = ArrayList<LatLng>()
        if (lastPoint != null) {
            movePoints.add(lastPoint)
            movePoints.add(latestPoint)
            mView.smoothMove(movePoints)
        }
        //更新轨迹线
        val lineOptions = PolylineOptions().addAll(pointList).width(10f)
            .color(ContextCompat.getColor(context, R.color.s_color_blue))
        mView.displayTrajectory(lineOptions)


    }

    override fun startPoint(startPoint: LatLng) {
        val startOptions = MarkerOptions().position(startPoint).anchor(0.5f, 0.5f)
        val currentOptions = MarkerOptions().position(startPoint).anchor(0.5f, 0.5f)
        mView.displayStartPoint(startOptions, currentOptions)
    }

    /**
     * 开始暂停view的闪烁
     */
    private fun startFlicker() {
        //已经在运行中，那么return
        if (animator != null && animator!!.hasStarted()) {
            return
        }

        if (animator == null) {
            animator = AlphaAnimation(0f, 0.5f)
            animator?.duration = 1000
            //恢复成初始的状态
            animator?.fillBefore = true
            animator?.repeatCount = ValueAnimator.INFINITE
            animator?.repeatMode = ValueAnimator.REVERSE
        }
        mView.startAnimator(animator!!)
        Logger.d("开始动画了")
    }

    /**
     * 停止闪烁
     */
    private fun stopFlicker() {
        if (animator != null && animator!!.hasStarted()) {
            animator?.cancel()
            Logger.d("停止动画")
            //恢复pause view的隐藏状态
        }
    }


}