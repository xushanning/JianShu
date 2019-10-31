package com.xu.module.video.debug

import com.xu.commonlib.base.BaseApplication
import com.xu.commonlib.di.module.AppModule
import com.xu.commonlib.di.module.ClientModule
import com.xu.module.video.di.VideoModule
import com.xu.module.video.di.UiModule

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * @author 言吾許
 */
@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        AppModule::class,//全局module
        ClientModule::class,//第三方库的module
        UiModule::class,
        VideoModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<BaseApplication>()
}