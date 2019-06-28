package com.xu.module.sport.ui.activity.realtime

import android.content.Context
import com.xu.commonlib.mvp.IModel
import com.xu.commonlib.mvp.IPresenter
import com.xu.commonlib.mvp.IView

/**
 * @author 言吾許
 */
interface IRealTimeTrajectoryContract {
    interface IRealTimeTrajectoryView : IView {

    }

    interface IRealTimeTrajectoryPresenter : IPresenter<IRealTimeTrajectoryView> {
        /**
         * 开始运动
         */
        fun startSport(context: Context)

        /**
         * 结束运动
         */
        fun stopSport()
    }

    interface IRealTimeTrajectoryModel : IModel {

    }
}