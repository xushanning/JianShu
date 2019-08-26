package com.xu.module.sport.ui.activity.historydetail

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.amap.api.maps.AMap
import com.xu.commonlib.base.BaseMvpActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.commonlib.db.entity.TrajectoryEntity
import com.xu.module.sport.R
import kotlinx.android.synthetic.main.s_activity_history_detail.*


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

    private lateinit var aMap: AMap

    override fun setLayoutId(): Int {
        return R.layout.s_activity_history_detail
    }

    override fun initView(savedInstanceState: Bundle?) {

        initMap(savedInstanceState)
        mPresenter.getDetailById(trajectoryId!!)
    }

    private fun initMap(savedInstanceState: Bundle?) {
        mv_detail.onCreate(savedInstanceState)
        aMap = mv_detail.map
        val uiSetting = aMap.uiSettings
        uiSetting.isRotateGesturesEnabled = false
        uiSetting.isTiltGesturesEnabled = false
    }

    override fun loadDetail(bean: TrajectoryEntity) {

    }
}