package com.xu.module.sport.ui.activity.historydetail

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.base.BaseMvpActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.module.sport.R

/**
 * @author 言吾許
 * 历史轨迹详情页
 */
@Route(path = ARouterPath.sportHistory)
class HistoryDetailActivity :
    BaseMvpActivity<IHistoryDetailContract.IHistoryDetailView, IHistoryDetailContract.IHistoryDetailPresenter>(),
    IHistoryDetailContract.IHistoryDetailView {
    @Autowired(name = "trajectoryId")
    @JvmField
    var trajectoryId: String? = null

    override fun setLayoutId(): Int {
        return R.layout.s_activity_history_detail
    }

    override fun initView(savedInstanceState: Bundle?) {
        mPresenter.getDetailById(trajectoryId!!)
    }
}