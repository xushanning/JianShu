package com.xu.module.sport.di

import com.xu.commonlib.di.scope.ActivityScope
import com.xu.commonlib.di.scope.FragmentScope
import com.xu.module.sport.ui.activity.main.MainActivity
import com.xu.module.sport.ui.fragment.sport.SportFragment
import com.xu.module.sport.ui.fragment.sport.SportModel
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author 言吾許
 */
@Module
abstract class SportAllActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    abstract fun contributeMainActivity(): MainActivity


    @FragmentScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    abstract fun contributeSportFragment(): SportFragment
}