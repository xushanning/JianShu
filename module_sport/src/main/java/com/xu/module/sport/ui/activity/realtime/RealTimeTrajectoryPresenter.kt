package com.xu.module.sport.ui.activity.realtime

import com.xu.commonlib.mvp.BasePresenter
import javax.inject.Inject

/**
 * @author 言吾許
 */
class RealTimeTrajectoryPresenter @Inject constructor() :
    BasePresenter<IRealTimeTrajectoryContract.IRealTimeTrajectoryView, IRealTimeTrajectoryContract.IRealTimeTrajectoryModel>(),
    IRealTimeTrajectoryContract.IRealTimeTrajectoryPresenter {
}