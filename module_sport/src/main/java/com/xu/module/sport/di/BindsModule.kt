package com.xu.module.sport.di

import com.xu.module.sport.ui.activity.main.IMainContract
import com.xu.module.sport.ui.activity.main.MainModel
import com.xu.module.sport.ui.activity.main.MainPresenter
import com.xu.module.sport.ui.activity.realtime.IRealTimeTrajectoryContract
import com.xu.module.sport.ui.activity.realtime.RealTimeTrajectoryModel
import com.xu.module.sport.ui.activity.realtime.RealTimeTrajectoryPresenter
import com.xu.module.sport.ui.fragment.home.HomeModel
import com.xu.module.sport.ui.fragment.home.HomePresenter
import com.xu.module.sport.ui.fragment.home.IHomeContract
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
abstract class BindsModule {
    //主页面
    @Binds
    abstract fun provideMainPresenter(mainPresenter: MainPresenter): IMainContract.IMainPresenter

    @Binds
    abstract fun provideMainModel(mainModel: MainModel): IMainContract.IMainModel

    //运动fragment
    @Binds
    abstract fun provideSportPresenter(sportPresenter: SportPresenter): ISportContract.ISportPresenter

    @Binds
    abstract fun provideSportModel(sportModel: SportModel): ISportContract.ISportModel

    //实时轨迹
    @Binds
    abstract fun provideRealTimeTrajectoryPresenter(presenter: RealTimeTrajectoryPresenter): IRealTimeTrajectoryContract.IRealTimeTrajectoryPresenter

    @Binds
    abstract fun provideRealTimeTrajectoryModel(model: RealTimeTrajectoryModel): IRealTimeTrajectoryContract.IRealTimeTrajectoryModel

    //home页面
    @Binds
    abstract fun provideHomePresenter(presenter: HomePresenter): IHomeContract.IHomePresenter

    @Binds
    abstract fun provideHomeModel(model: HomeModel): IHomeContract.IHomeModel
}