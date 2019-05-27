package com.xu.commonlib.di.component

import com.xu.commonlib.base.BaseApplication
import com.xu.commonlib.di.module.AppModule
import com.xu.commonlib.di.module.ClientModule
import dagger.Component
import javax.inject.Singleton

/**
 * @author 言吾許
 */
@Singleton
@Component(modules = [AppModule::class, ClientModule::class])
interface AppComponent {
    fun application(): BaseApplication
}