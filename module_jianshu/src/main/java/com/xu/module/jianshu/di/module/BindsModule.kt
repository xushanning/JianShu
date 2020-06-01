package com.xu.module.jianshu.di.module

import com.xu.module.jianshu.ui.coroutine.CoroutineModel
import com.xu.module.jianshu.ui.coroutine.CoroutinePresenter
import com.xu.module.jianshu.ui.coroutine.ICoroutineContract
import dagger.Binds
import dagger.Module

@Module
abstract class BindsModule {

    @Binds
    abstract fun provideCoroutinePresenter(coroutinePresenter: CoroutinePresenter): ICoroutineContract.ICoroutinePresenter

    @Binds
    abstract fun provideCoroutineModel(coroutineModel: CoroutineModel): ICoroutineContract.ICoroutineModel
}