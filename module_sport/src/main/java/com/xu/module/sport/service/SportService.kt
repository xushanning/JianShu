package com.xu.module.sport.service

import android.content.Intent
import android.content.IntentFilter
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.os.PowerManager
import com.amap.api.location.AMapLocation
import com.amap.api.location.AMapLocationClient
import com.amap.api.location.AMapLocationClientOption
import com.amap.api.location.AMapLocationListener
import com.amap.api.maps.AMapUtils
import com.amap.api.maps.model.LatLng
import com.orhanobut.logger.Logger
import com.xu.commonlib.db.dao.ISportDao
import com.xu.commonlib.db.entity.PointBean
import com.xu.commonlib.db.entity.TrajectoryEntity
import com.xu.commonlib.utlis.TimeUtil
import com.xu.commonlib.utlis.TransformUtil
import com.xu.module.sport.R
import com.xu.module.sport.beans.ScreenDataBean
import com.xu.module.sport.receiver.ScreenLockReceiver
import dagger.android.DaggerService
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.greenrobot.eventbus.EventBus
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * @author 言吾許
 */
class SportService : DaggerService(), AMapLocationListener {

    @Inject
    lateinit var sportDao: ISportDao


    /**
     * 当前运动轨迹的id
     */
    private lateinit var trajectoryId: String

    private var onLocationChangeListener: OnLocationChangeListener? = null

    private var onTrajectoryDeleteListener: OnTrajectoryDeleteListener? = null

    private var onDbUpdateListener: OnDbUpdateListener? = null

    private var locationClient: AMapLocationClient? = null

    private var locationClientOption: AMapLocationClientOption? = null

    private var mediaPlayer: MediaPlayer? = null

    private var mCompositeDisposable = CompositeDisposable()

    private lateinit var entity: TrajectoryEntity
    /**
     *  存储轨迹点
     */
    private lateinit var trajectoryPoints: MutableList<PointBean>

    /**
     * 计时的dis
     */
    private var timerDis: Disposable? = null
    private var musicDis: Disposable? = null

    /**
     * 轨迹点集合
     */
    //  private lateinit var pointList: MutableList<LatLng>

    /**
     * 最新纬度
     */
//    private var latestLatitude = 0.0
    /**
     * 最新经度
     */
//    private var latestLongitude = 0.0
    /**
     * 最新速度
     */
    private var lastSpeed = 0f
    /**
     * 最新纬度
     */
    private var lastAltitude = 0.0
    /**
     * 从开始运动到现在总用时
     */
    private var totalTime = 0L
    /**
     * 运动用时，不算暂停
     */
    private var sportTime = 0L

    private var lastPoint: LatLng? = null

    private var latestPoint: LatLng? = null
    /**
     * 运动距离：默认为0
     */
    private var sportMileage = 0f

    /**
     * 相同点返回的次数
     */
    private var sameLocationCount = 0
    /**
     * 是否暂停
     */
    private var pause = false
    /**
     * 锁屏广播监听
     */
    private var lockReceiver: ScreenLockReceiver? = null


    companion object {
        /**
         * 定位间隔2000毫秒
         */
        private const val LOCATION_INTERVAL = 2000L
        /**
         * 更新数据库间隔 单位：秒
         */
        private const val UPDATE_DB_INTERVAL = 3
        /**
         * 暂停阈值
         */
        private const val PAUSE_THRESHOLD = 3
    }

    override fun onBind(intent: Intent?): IBinder? {
        return SportBind()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_NOT_STICKY
    }


    inner class SportBind : Binder(), ISportBind {
        override fun startSport() {
            Logger.d("开始运动")
            //  pointList = ArrayList()
            initLocation()
            generateNewTrajectory()
            startTimer()
            startMusic()
            startReceiver()
        }

        override fun stopSport() {
            locationClient?.stopLocation()
            timerDis?.dispose()
            updateDb(true)
            unregisterReceiver(lockReceiver)
        }

        override fun continueSport() {

        }

        override fun deleteTooShortTrajectory() {
            //首先 解除计时
            timerDis?.dispose()
            deleteCurrentTrajectory()
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
        locationClientOption?.locationMode =
                AMapLocationClientOption.AMapLocationMode.Hight_Accuracy
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
        timerDis = Observable
                .interval(0, 1, TimeUnit.SECONDS)
                .compose(TransformUtil.defaultSchedulers())
                .subscribe({
                    totalTime++
                    if (lastPoint == null && latestPoint != null) {
                        //第一个点
                        onLocationChangeListener?.startPoint(latestPoint!!)
                    }
                    //进行重复次数统计
                    if (latestPoint != null && lastPoint != null) {
                        if (latestPoint == lastPoint) {
                            sameLocationCount++
                        } else {
                            //两个点不同，复位次数统计
                            sameLocationCount = 0
                            //计算距离
                            sportMileage += AMapUtils.calculateLineDistance(lastPoint, latestPoint)
                        }
                    }
                    //判断是否应该暂停
                    if (sameLocationCount >= PAUSE_THRESHOLD) {
                        //大于等于三次，判定为不动
                        pause = true
                    } else {
                        pause = false
                        //运动时间增加
                        if (latestPoint != null) {
                            sportTime++
                        }
                    }

                    if (latestPoint != null) {
                        onLocationChangeListener?.onLocationChange(
                                latestPoint!!,
                                lastPoint,
                                pause,
                                lastSpeed,
                                lastAltitude,
                                TimeUtil.getTime(sportTime),
                                sportMileage
                        )
                        //抛出锁屏页的数据
                        val screenData = ScreenDataBean(sportMileage, lastSpeed, TimeUtil.getTime(sportTime))
                        EventBus.getDefault().post(screenData)
                    }
                    lastPoint = latestPoint
                    updateDb(false)
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

    /**
     * 注册锁屏广播
     */
    private fun startReceiver() {
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_SCREEN_OFF)
        lockReceiver = ScreenLockReceiver()
        registerReceiver(lockReceiver, filter)
    }


    override fun onLocationChanged(location: AMapLocation?) {
        if (location?.errorCode == 0) {
            //定位成功
            latestPoint = LatLng(location.latitude, location.longitude)
            trajectoryPoints.add(
                    PointBean(
                            location.latitude,
                            location.longitude,
                            location.altitude,
                            System.currentTimeMillis()
                    )
            )
            lastSpeed = location.speed
            lastAltitude = location.altitude
        } else {
            Logger.d("定位出错:" + location?.errorInfo)
        }
    }

    /**
     * 初始化一条
     */
    private fun generateNewTrajectory() {
        trajectoryPoints = ArrayList()
        entity = TrajectoryEntity()
        trajectoryId = generateTrajectoryId()
        entity.trajectoryId = trajectoryId
        entity.startTime = System.currentTimeMillis()
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH) + 1
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        entity.year = year
        entity.month = month
        entity.day = day
        val newDis = sportDao.saveSportTrajectory(entity)
                .compose(TransformUtil.defaultCompletableSchedulers())
                .subscribe({}, { Logger.d(it.message) })
        mCompositeDisposable.add(newDis)
    }

    /**
     * 生成轨迹id
     */
    private fun generateTrajectoryId(): String {
        val s = UUID.randomUUID().toString()
        return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(
                19,
                23
        ) + s.substring(24)
    }

    /**
     *  更新数据库轨迹数据
     */
    private fun updateDb(complete: Boolean) {
        if (totalTime.toInt() % UPDATE_DB_INTERVAL == 0) {
            entity.sportTime = sportTime
            entity.totalTime = totalTime
            entity.complete = complete
            entity.lastInsertTime = System.currentTimeMillis()
            entity.trajectoryPoints = trajectoryPoints
            entity.sportMileage = sportMileage
            val updateDis = sportDao.updateSportTrajectory(entity)
                    .compose(TransformUtil.defaultCompletableSchedulers())
                    .subscribe({
                        if (complete) {
                            onDbUpdateListener?.onDbUpdate()
                        }
                    }, { Logger.d(it.message) })
            mCompositeDisposable.add(updateDis)
        }
    }

    /**
     * 轨迹过短，删除此条数据
     */
    private fun deleteCurrentTrajectory() {
        val deleteDis = sportDao.deleteSportTrajectory(entity)
                .compose(TransformUtil.defaultSingleSchedulers())
                .subscribe({
                    Logger.d("删除当前轨迹成功")
                    onTrajectoryDeleteListener?.onTrajectoryDelete()
                }, { Logger.d(it.message) })
        mCompositeDisposable.add(deleteDis)
    }

    fun setOnLocationChangeListener(onLocationChangeListener: OnLocationChangeListener) {
        this.onLocationChangeListener = onLocationChangeListener
    }

    /**
     * 轨迹删除监听
     */
    fun setOnTrajectoryDeleteListener(onTrajectoryDeleteListener: OnTrajectoryDeleteListener) {
        this.onTrajectoryDeleteListener = onTrajectoryDeleteListener
    }

    /**
     * 停止更新完数据库监听
     */
    fun setOnDbUpdateListener(onDbUpdateListener: OnDbUpdateListener) {
        this.onDbUpdateListener = onDbUpdateListener
    }

    interface OnDbUpdateListener {
        /**
         * 数据库更新完
         */
        fun onDbUpdate()
    }

    interface OnTrajectoryDeleteListener {
        /**
         * 轨迹删除
         */
        fun onTrajectoryDelete()
    }

    interface OnLocationChangeListener {
        /**
         * @param latestPoint 最新点
         * @param lastPoint 上一个点
         * @param speed 速度
         * @param altitude 海拔
         * @param pause 是否暂停
         * @param sportTime 已经用时，单位:秒
         * @param sportMileage 运动距离
         */
        fun onLocationChange(
                latestPoint: LatLng,
                lastPoint: LatLng?,
                pause: Boolean,
                speed: Float,
                altitude: Double,
                sportTime: String,
                sportMileage: Float
        )

        /**
         * 第一个点
         */
        fun startPoint(startPoint: LatLng)
    }

    override fun onDestroy() {
        super.onDestroy()
        mCompositeDisposable.dispose()
        mediaPlayer?.stop()
        mediaPlayer?.release()
        timerDis?.dispose()
        musicDis?.dispose()
        locationClient?.onDestroy()
        unregisterReceiver(lockReceiver)
        Logger.d("service 被销毁了")
    }
}