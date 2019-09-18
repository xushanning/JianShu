package com.xu.module.sport.debug

import com.xu.commonlib.base.BaseApplication
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
}