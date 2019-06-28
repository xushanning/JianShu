package com.xu.module.sport.ui.activity.realtime

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.view.View
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


    override fun startSport(context: Context) {
        val intent = Intent(context, SportService::class.java)
        context.bindService(intent, object : ServiceConnection {
            override fun onServiceDisconnected(name: ComponentName?) {

            }

            override fun onServiceConnected(name: ComponentName?, binder: IBinder?) {
                service = binder as SportService.SportBind
                service?.startSport()
                service?.getSportService()?.setOnLocationChangeListener(this@RealTimeTrajectoryPresenter)
//                v_start.visibility = View.GONE
//                tv_start.visibility = View.GONE
//                sfv_finish_sport.visibility = View.VISIBLE
            }

        }, Context.BIND_AUTO_CREATE)
    }

    override fun stopSport() {

    }

    override fun onLocationChange(latitude: Double) {
        //运动位置变换回调

    }
}