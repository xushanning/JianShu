package com.xu.module.sport.ui.activity.realtime

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.view.View
import com.amap.api.maps.model.LatLng
import com.orhanobut.logger.Logger
import com.xu.commonlib.mvp.BasePresenter
import com.xu.module.sport.service.ISportBind
import com.xu.module.sport.service.SportService
import kotlinx.android.synthetic.main.s_activity_real_time_trajectory.*
import javax.inject.Inject

/**
 * @author 言吾許
 */
class RealTimeTrajectoryPresenter @Inject constructor() :
    BasePresenter<IRealTimeTrajectoryContract.IRealTimeTrajectoryView, IRealTimeTrajectoryContract.IRealTimeTrajectoryModel>(),
    IRealTimeTrajectoryContract.IRealTimeTrajectoryPresenter, SportService.OnLocationChangeListener {
    private var service: ISportBind? = null


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
        val intent = Intent(context, SportService::class.java)
        context.bindService(intent, connection, Context.BIND_AUTO_CREATE)
    }

    override fun stopSport(context: Context) {
        service?.stopSport()
        context.unbindService(connection)

    }

    override fun onLocationChange(latitude: Double, longitude: Double, speed: Float, altitude: Double, usedTime: Long) {
        //运动位置变换回调
        Logger.d(latitude)
        Logger.d(longitude)
        if (latitude != 0.0 && longitude != 0.0) {
            mView.displayTrajectory(LatLng(latitude, longitude))
        }

    }
}