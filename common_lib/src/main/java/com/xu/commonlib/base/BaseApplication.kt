package com.xu.commonlib.base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.xu.commonlib.BuildConfig
import com.xu.commonlib.di.component.AppComponent
import com.xu.commonlib.utlis.LoggerStrategy

/**
 * @author 言吾許
 */
class BaseApplication : Application() {
    private lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()
        initLogger()
        initARouter()
    }

    /**
     * 初始化logger
     */
    private fun initLogger() {
        val formatStrategy: FormatStrategy = PrettyFormatStrategy
            .newBuilder()
            .showThreadInfo(false)
            .logStrategy(LoggerStrategy())
            .tag("hezhang")
            .build()
        Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }

    /**
     * 初始化ARouter
     */
    private fun initARouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }

    private fun initAppComponent() {

    }

}