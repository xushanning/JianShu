package com.xu.module.sport.di.module

import com.xu.module.sport.ui.activity.main.IMainContract
import com.xu.module.sport.ui.activity.main.MainModel
import com.xu.module.sport.ui.activity.main.MainPresenter
import dagger.Module
import dagger.Provides

/**
 * @author 言吾許
 */
@Module
class ActivityModule {

    @Provides
    fun provideMainPresenter(mainPresenter: MainPresenter): IMainContract.IMainPresenter {
        return mainPresenter
    }

    @Provides
    fun provideMainModule(mainModel: MainModel): IMainContract.IMainModel {
        return mainModel
    }


}