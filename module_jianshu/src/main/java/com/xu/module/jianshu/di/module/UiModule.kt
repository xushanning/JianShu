package com.xu.module.jianshu.di.module

import com.xu.commonlib.di.scope.ActivityScope
import com.xu.module.jianshu.ui.coroutine.CoroutineActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [BindsModule::class])
    abstract fun contributeMainActivity(): CoroutineActivity
}