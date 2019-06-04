package com.xu.module.sport.di

import com.xu.module.sport.ui.activity.main.IMainContract
import com.xu.module.sport.ui.activity.main.MainModel
import com.xu.module.sport.ui.activity.main.MainPresenter
import com.xu.module.sport.ui.activity.realtime.IRealTimeTrajectoryContract
import com.xu.module.sport.ui.activity.realtime.RealTimeTrajectoryModel
import com.xu.module.sport.ui.activity.realtime.RealTimeTrajectoryPresenter
import com.xu.module.sport.ui.fragment.sport.ISportContract
import com.xu.module.sport.ui.fragment.sport.SportModel
import com.xu.module.sport.ui.fragment.sport.SportPresenter
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
    abstract fun provideMainModel(mainModel: MainModel): IMainContract.IMainModel

    @Binds
    abstract fun provideSportPresenter(sportPresenter: SportPresenter): ISportContract.ISportPresenter

    @Binds
    abstract fun provideSportModel(sportModel: SportModel): ISportContract.ISportModel

    @Binds
    abstract fun provideRealTimeTrajectoryPresenter(presenter: RealTimeTrajectoryPresenter): IRealTimeTrajectoryContract.IRealTimeTrajectoryPresenter

    @Binds
    abstract fun provideRealTimeTrajectoryModel(model: RealTimeTrajectoryModel): IRealTimeTrajectoryContract.IRealTimeTrajectoryModel
}