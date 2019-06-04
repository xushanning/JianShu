package com.xu.module.sport.ui.activity.realtime

import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.base.BaseMvpActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.module.sport.R

/**
 * @author 言吾許
 * 运动实时轨迹界面
 */
@Route(path = ARouterPath.sportRealTimeTrajectory)
class RealTimeTrajectoryActivity :
    BaseMvpActivity<IRealTimeTrajectoryContract.IRealTimeTrajectoryView, IRealTimeTrajectoryContract.IRealTimeTrajectoryPresenter>(),
    IRealTimeTrajectoryContract.IRealTimeTrajectoryView {
    override fun setLayoutId(): Int {
        return R.layout.s_activity_real_time_trajectory
    }

    override fun initView() {
    }
}