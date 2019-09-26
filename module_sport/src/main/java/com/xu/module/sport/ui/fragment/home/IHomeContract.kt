package com.xu.module.sport.ui.fragment.home

import com.xu.commonlib.db.entity.TrajectoryEntity
import com.xu.commonlib.mvp.IModel
import com.xu.commonlib.mvp.IPresenter
import com.xu.commonlib.mvp.IView
import io.reactivex.Flowable


/**
 * @author 言吾許
 */
interface IHomeContract {
    interface IHomeView : IView {
        /**
         * 加载本月运动统计
         * @param sportMileage 运动距离（公里）
         * @param sportRank 运动排名（写死）
         * @param sportTime 运动时间
         */
        fun loadCurrentMonthSportStatistics(sportMileage: String, sportRank: String, sportTime: String)
    }

    interface IHomePresenter : IPresenter<IHomeView> {
        /**
         * 获取当月的运动的统计数据
         */
        fun getCurrentMonthSportStatistics(sportType: Int)
    }

    interface IHomeModel : IModel {
        /**
         * 获取当月的运动的统计数据
         */
        fun getCurrentMonthSportStatistics(sportType: Int, month: Int): Flowable<List<TrajectoryEntity>>
    }
}