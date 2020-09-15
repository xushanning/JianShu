package com.xu.module.wan.debug

import com.xu.commonlib.base.BaseApplication
import com.xu.easyload.ext.initEasyLoad
import com.xu.module.wan.weight.state.LoadingState
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
        initEasyLoad {
            addGlobalState(LoadingState())
            setGlobalDefaultState(LoadingState::class.java)
        }
    }

}