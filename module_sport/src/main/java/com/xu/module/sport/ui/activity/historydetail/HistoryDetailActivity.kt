package com.xu.module.sport.ui.activity.historydetail

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.amap.api.maps.AMap
import com.amap.api.maps.CameraUpdateFactory
import com.amap.api.maps.model.LatLngBounds
import com.amap.api.maps.model.MarkerOptions
import com.amap.api.maps.model.PolylineOptions
import com.xu.commonlib.base.BaseMvpActivity
import com.xu.commonlib.constant.ARouterPath
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
    /**
     * 轨迹唯一id
     */
    @Autowired(name = "trajectoryId")
    @JvmField
    var trajectoryId: String? = null

    private lateinit var aMap: AMap

    override fun setLayoutId(): Int {
        return R.layout.s_activity_history_detail
    }

    override fun initView(savedInstanceState: Bundle?) {

        initMap(savedInstanceState)
        mPresenter.getDetailById(trajectoryId!!, applicationContext)
    }

    private fun initMap(savedInstanceState: Bundle?) {
        mv_detail.onCreate(savedInstanceState)
        aMap = mv_detail.map
        val uiSetting = aMap.uiSettings
        uiSetting.isRotateGesturesEnabled = false
        uiSetting.isTiltGesturesEnabled = false
    }

    override fun displayHistoryTrajectory(lineOptions: PolylineOptions) {
        aMap.addPolyline(lineOptions)
    }

    override fun displayStartEnd(startPoint: MarkerOptions, endPoint: MarkerOptions) {
        aMap.addMarker(startPoint)
        aMap.addMarker(endPoint)
    }

    override fun setBound(latLngBounds: LatLngBounds) {
        aMap.animateCamera(CameraUpdateFactory.newLatLngBoundsRect(latLngBounds, 200, 200, 200, 200))
    }

    override fun loadSportData(mileage: String, speed: String, climb: String, time: String, heat: String) {
        tv_mileage_name.text = mileage
        tv_speed.text = speed
        tv_climb.text = climb
        tv_time.text = time
        tv_heat.text = heat
    }
}