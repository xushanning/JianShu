package com.xu.module.sport.di

import com.xu.module.sport.ui.activity.main.IMainContract
import com.xu.module.sport.ui.activity.main.MainModel
import com.xu.module.sport.ui.activity.main.MainPresenter
import dagger.Binds
import dagger.Module

/**
 * @author 言吾許
 * 所有提供都放在这里面，如果过大，可以进行拆分
 *
 */
@Module
abstract class ActivityModule {


    @Binds
    abstract fun provideMainPresenter(mainPresenter: MainPresenter): IMainContract.IMainPresenter

    @Binds
    abstract fun provideMainModule(mainModel: MainModel): IMainContract.IMainModel


}