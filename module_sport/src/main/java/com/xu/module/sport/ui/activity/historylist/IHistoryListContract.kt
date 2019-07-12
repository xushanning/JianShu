package com.xu.module.sport.ui.activity.historylist

import com.xu.commonlib.db.entity.TrajectoryEntity
import com.xu.commonlib.mvp.IModel
import com.xu.commonlib.mvp.IPresenter
import com.xu.commonlib.mvp.IView
import io.reactivex.Flowable

/**
 * @author 言吾許
 */
interface IHistoryListContract {

    interface IHistoryListView : IView {

        /**
         * 加载运动的年份list
         */
        fun loadSportYear(yearList: List<Int>)

        /**
         * 加载运动月份list
         */
        fun loadSportMonth(monthList: List<Int>)

        /**
         * 加载运动历史列表
         */
        fun loadSportHistoryList(historyList: List<TrajectoryEntity>)
    }

    interface IHistoryListPresenter : IPresenter<IHistoryListView> {
        /**
         * 获取有数据的年份
         */
        fun getSportYear()

        /**
         * 获取有运动记录年的月份
         */
        fun getSportMonthByYear(year: Int)

        /**
         * 获取某年某月份的运动记录
         */
        fun getSportHistoryByMonth(year: Int, month: Int)
    }

    interface IHistoryListModel : IModel {
        fun getSportYear(): Flowable<List<TrajectoryEntity>>

        fun getSportMonthByYear(year: Int): Flowable<List<TrajectoryEntity>>

        fun getSportHistoryByMonth(year: Int, month: Int): Flowable<List<TrajectoryEntity>>
    }
}