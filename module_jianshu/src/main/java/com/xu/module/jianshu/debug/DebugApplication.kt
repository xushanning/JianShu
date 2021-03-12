package com.xu.module.jianshu.debug

import com.xu.commonlib.base.BaseApplication
import dagger.hilt.android.HiltAndroidApp

/**
 * @author 言吾許
 */
@HiltAndroidApp
class DebugApplication : BaseApplication() {


    override fun onCreate() {
        super.onCreate()
        initEasyLoad()
    }

    private fun initEasyLoad() {
        //初始化全局
//        EasyLoad.instance
//            .beginBuilder()
//            .addGlobalState(LoadingState())
//            .addGlobalState(ErrorState())
//            .addGlobalState(GlobalDefaultState())
//            .setGlobalDefaultState(GlobalDefaultState::class.java)
    }

}