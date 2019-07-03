package com.xu.module.sport.ui.activity.realtime

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import androidx.core.content.ContextCompat
import com.amap.api.maps.model.LatLng
import com.amap.api.maps.model.MarkerOptions
import com.amap.api.maps.model.PolylineOptions
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
        context.bindService(intent, connection, Context.BIND_AUTO_CREATE)
    }

    override fun stopSport(context: Context) {
        service?.stopSport()
        context.unbindService(connection)

    }

    override fun onLocationChange(
        latestPoint: LatLng,
        lastPoint: LatLng?,
        pause: Boolean,
        speed: Float,
        altitude: Double,
        sportTime: String
    ) {
        mView.refreshTime(sportTime)
        if (pause) {
            //todo 显示暂停的样式

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
}