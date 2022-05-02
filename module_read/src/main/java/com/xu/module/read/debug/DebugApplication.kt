package com.xu.module.read.debug

import com.xu.commonlib.base.BaseApplication
import dagger.hilt.android.HiltAndroidApp

/**
 * @author 言吾許
 */
@HiltAndroidApp
class DebugApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {

    }

}