package com.xu.module.jianshu.debug

import com.xu.commonlib.base.BaseApplication
import com.xu.module.easyload.EasyLoad
import com.xu.module.jianshu.ui.easyload.state.ErrorState
import com.xu.module.jianshu.ui.easyload.state.LoadingState
import com.xu.module.jianshu.ui.easyload.state.GlobalDefaultState
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * @author 言吾許
 */
class DebugApplication : BaseApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val injector = DaggerAppComponent.builder().create(this)
        injector.inject(this)
        return injector
    }

    override fun onCreate() {
        super.onCreate()
        initEasyLoad()
    }

    private fun initEasyLoad() {
        //初始化全局
        EasyLoad.instance
            .beginBuilder()
            .addGlobalState(LoadingState())
            .addGlobalState(ErrorState())
            .addGlobalState(GlobalDefaultState())
            .setGlobalDefaultState(GlobalDefaultState::class.java)
    }

}