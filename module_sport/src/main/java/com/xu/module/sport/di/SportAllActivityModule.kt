package com.xu.module.sport.di

import com.xu.commonlib.di.scope.ActivityScope
import com.xu.module.sport.ui.activity.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author 言吾許
 */
@Module
abstract class SportAllActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    abstract fun ContributesMianActivity(): MainActivity
}