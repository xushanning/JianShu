package com.xu.commonlib.base

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.xu.commonlib.BuildConfig
import com.xu.commonlib.utlis.LoggerStrategy

/**
 * @author 言吾許
 */
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initLogger()
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
}