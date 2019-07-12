package com.xu.module.sport.ui.activity.historydetail

import com.xu.commonlib.db.entity.TrajectoryEntity
import com.xu.commonlib.mvp.IModel
import com.xu.commonlib.mvp.IPresenter
import com.xu.commonlib.mvp.IView
import io.reactivex.Flowable

/**
 * @author 言吾許
 */
interface IHistoryDetailContract {
    interface IHistoryDetailView : IView {

    }

    interface IHistoryDetailPresenter : IPresenter<IHistoryDetailView> {
        /**
         * 通过轨迹id获取运动的详情
         */
        fun getDetailById(trajectoryId: String)
    }

    interface IHistoryDetailModel : IModel {
        fun getDetailById(trajectoryId: String): Flowable<TrajectoryEntity>
    }
}