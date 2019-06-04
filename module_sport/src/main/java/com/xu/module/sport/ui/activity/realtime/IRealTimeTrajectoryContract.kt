package com.xu.module.sport.ui.activity.realtime

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

    }

    interface IRealTimeTrajectoryModel : IModel {

    }
}