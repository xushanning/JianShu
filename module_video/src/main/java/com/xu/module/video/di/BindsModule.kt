package com.xu.module.video.di

import com.xu.module.video.ui.activity.main.IMainContract
import com.xu.module.video.ui.activity.main.MainModel
import com.xu.module.video.ui.activity.main.MainPresenter
import com.xu.module.video.ui.fragment.completed.CompletedModel
import com.xu.module.video.ui.fragment.completed.CompletedPresenter
import com.xu.module.video.ui.fragment.completed.ICompletedContract
import com.xu.module.video.ui.fragment.downloading.DownloadingModel
import com.xu.module.video.ui.fragment.downloading.DownloadingPresenter
import com.xu.module.video.ui.fragment.downloading.IDownloadingContract
import dagger.Binds
import dagger.Module

/**
 * @author 言吾許
 */
@Module
abstract class BindsModule {
    //主页面
    @Binds
    abstract fun provideMainPresenter(mainPresenter: MainPresenter): IMainContract.IMainPresenter

    @Binds
    abstract fun provideMainModel(mainModel: MainModel): IMainContract.IMainModel

    //已经完成
    @Binds
    abstract fun provideCompletedPresenter(completedPresenter: CompletedPresenter): ICompletedContract.ICompletedPresenter

    @Binds
    abstract fun provideCompletedModel(completedModel: CompletedModel): ICompletedContract.ICompletedModel

    //正在下载
    @Binds
    abstract fun provideDownloadingPresenter(downloadingPresenter: DownloadingPresenter): IDownloadingContract.IDownloadingPresenter

    @Binds
    abstract fun provideDownloadingModel(downloadingModel: DownloadingModel): IDownloadingContract.IDownloadingModel
}