package com.xu.module.sport.di

import com.xu.commonlib.di.scope.ActivityScope
import com.xu.commonlib.di.scope.FragmentScope
import com.xu.module.sport.service.SportService
import com.xu.module.sport.ui.activity.historydetail.HistoryDetailActivity
import com.xu.module.sport.ui.activity.historylist.HistoryListActivity
import com.xu.module.sport.ui.activity.main.MainActivity
import com.xu.module.sport.ui.activity.realtime.RealTimeTrajectoryActivity
import com.xu.module.sport.ui.fragment.home.HomeFragment
import com.xu.module.sport.ui.fragment.sport.SportFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author 言吾許
 */
@Module
abstract class UiModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [BindsModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [BindsModule::class])
    abstract fun contributeHistoryListActivity(): HistoryListActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [BindsModule::class])
    abstract fun contributeHistoryActivity(): HistoryDetailActivity


    @FragmentScope
    @ContributesAndroidInjector(modules = [BindsModule::class])
    abstract fun contributeSportFragment(): SportFragment

    @ActivityScope
    @ContributesAndroidInjector(modules = [BindsModule::class])
    abstract fun contributeRealTimeTrajectoryActivity(): RealTimeTrajectoryActivity


    @FragmentScope
    @ContributesAndroidInjector(modules = [BindsModule::class])
    abstract fun comtributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun comtributeSportService(): SportService
}