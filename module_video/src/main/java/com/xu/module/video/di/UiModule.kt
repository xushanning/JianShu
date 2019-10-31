package com.xu.module.video.di

import com.xu.commonlib.di.scope.ActivityScope
import com.xu.commonlib.di.scope.FragmentScope
import com.xu.module.video.ui.activity.main.MainActivity
import com.xu.module.video.ui.fragment.completed.CompletedFragment
import com.xu.module.video.ui.fragment.downloading.DownloadingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author 言吾許
 */
@Module
abstract class UiModule {
    //主界面
    @ActivityScope
    @ContributesAndroidInjector(modules = [BindsModule::class])
    abstract fun contributeMainActivity(): MainActivity

    //已完成
    @FragmentScope
    @ContributesAndroidInjector(modules = [BindsModule::class])
    abstract fun contributeCompletedFragment(): CompletedFragment

    //正在下载
    @FragmentScope
    @ContributesAndroidInjector(modules = [BindsModule::class])
    abstract fun contributeDownloadingFragment(): DownloadingFragment
}