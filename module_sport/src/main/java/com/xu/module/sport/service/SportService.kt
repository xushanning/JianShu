package com.xu.module.sport.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.os.PowerManager
import com.amap.api.location.AMapLocation
import com.amap.api.location.AMapLocationClient
import com.amap.api.location.AMapLocationClientOption
import com.amap.api.location.AMapLocationListener
import com.orhanobut.logger.Logger
import com.xu.commonlib.utlis.TransformUtil
import com.xu.module.sport.R
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

/**
 * @author 言吾許
 */
class SportService : Service(), AMapLocationListener {

    private var onLocationChangeListener: OnLocationChangeListener? = null

    private var locationClient: AMapLocationClient? = null

    private var locationClientOption: AMapLocationClientOption? = null

    private var mediaPlayer: MediaPlayer? = null

    /**
     * 计时的dis
     */
    private var timerDis: Disposable? = null
    private var musicDis: Disposable? = null

    /**
     * 最新纬度
     */
    private var lastLatitude = 0.0
    /**
     * 最新经度
     */
    private var lastLongitude = 0.0
    /**
     * 最新速度
     */
    private var lastSpeed = 0f
    /**
     * 最新纬度
     */
    private var lastAltitude = 0.0


    companion object {
        //定位间隔2000毫秒
        const val LOCATION_INTERVAL = 2000L
    }

    override fun onBind(intent: Intent?): IBinder? {
        return SportBind()
    }


    inner class SportBind : Binder(), ISportBind {
        override fun startSport() {
            Logger.d("开始运动")
            initLocation()
            startTimer()
            startMusic()
        }

        override fun stopSport() {
            locationClient?.stopLocation()
        }

        override fun continueSport() {

        }

        override fun getSportService(): SportService {
            return this@SportService
        }
    }

    /**
     * 初始化高德地图定位
     */
    private fun initLocation() {
        locationClient = AMapLocationClient(applicationContext)
        locationClientOption = AMapLocationClientOption()
        //设置模式为运动
        locationClientOption?.locationPurpose = AMapLocationClientOption.AMapLocationPurpose.Sport
        //高精度定位
        locationClientOption?.locationMode = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy
        locationClientOption?.interval = LOCATION_INTERVAL
        //不需要返回地址信息
        locationClientOption?.isMockEnable = false
        locationClient?.setLocationOption(locationClientOption)
        locationClient?.setLocationListener(this@SportService)
        locationClient?.stopLocation()
        locationClient?.startLocation()
    }

    /**
     * 开始计时，并发送数据
     */
    private fun startTimer() {
        timerDis = Observable.interval(0, 1, TimeUnit.SECONDS)
            .compose(TransformUtil.defaultSchedulers())
            .subscribe({
                onLocationChangeListener?.onLocationChange(lastLatitude, lastLongitude, lastSpeed, lastAltitude, it)
            }, { Logger.d(it.message) })
    }

    /**
     * 开启音乐保活
     */
    private fun startMusic() {
        musicDis = Observable
            .create<Any> {
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(applicationContext, R.raw.s_no_notice)
                    mediaPlayer?.setWakeMode(this, PowerManager.PARTIAL_WAKE_LOCK)
                    mediaPlayer?.isLooping = true
                    mediaPlayer?.start()
                }
            }.compose<Any>(TransformUtil.defaultSchedulers())
            .subscribe({}, { Logger.d(it.message) })
    }

    override fun onLocationChanged(location: AMapLocation?) {
        if (location?.errorCode == 0) {
            //定位成功
            lastLatitude = location.latitude
            lastLongitude = location.longitude
            lastSpeed = location.speed
            lastAltitude = location.altitude
        } else {
            Logger.d("定位出错:" + location?.errorInfo)
        }
    }

    fun setOnLocationChangeListener(onLocationChangeListener: OnLocationChangeListener) {
        this.onLocationChangeListener = onLocationChangeListener
    }

    interface OnLocationChangeListener {
        /**
         * @param latitude 纬度
         * @param longitude 经度
         * @param speed 速度
         * @param altitude 海拔
         * @param usedTime 已经用时，单位:秒
         */
        fun onLocationChange(latitude: Double, longitude: Double, speed: Float, altitude: Double, usedTime: Long)
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.stop()
        mediaPlayer?.release()
        timerDis?.dispose()
        musicDis?.dispose()
        locationClient?.onDestroy()
    }
}