package com.xu.module.sport.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import com.orhanobut.logger.Logger

/**
 * @author 言吾許
 */
class SportService : Service() {

    private var onLocationChangeListener: OnLocationChangeListener? = null

    override fun onCreate() {
        super.onCreate()

    }

    override fun onBind(intent: Intent?): IBinder? {
        return SportBind()
    }


    inner class SportBind : Binder(), ISportBind {
        override fun startSport() {
            Logger.d("开始运动")
        }

        override fun stopSport() {
        }

        override fun continueSport() {
        }

        override fun getSportService(): SportService {
            return this@SportService
        }
    }

    fun setOnLocationChangeListener(onLocationChangeListener: OnLocationChangeListener) {
        this.onLocationChangeListener = onLocationChangeListener
    }

    interface OnLocationChangeListener {
        fun onLocationChange(latitude: Double)
    }
}