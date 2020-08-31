package com.xu.module.wan.di.module

import com.xu.commonlib.di.scope.ActivityScope
import com.xu.module.wan.ui.login.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun loginActivity(): LoginActivity
}
