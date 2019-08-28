package com.xu.module.sport.ui.activity.historydetail

import android.content.Context
import androidx.core.content.ContextCompat
import com.amap.api.maps.model.*
import com.orhanobut.logger.Logger
import com.xu.commonlib.mvp.BasePresenter
import com.xu.commonlib.utlis.TimeUtil
import com.xu.commonlib.utlis.TransformUtil
import com.xu.commonlib.utlis.VectorUtil
import com.xu.module.sport.R
import javax.inject.Inject

/**
 * @author 言吾許
 */
class HistoryDetailPresenter @Inject constructor() :
    BasePresenter<IHistoryDetailContract.IHistoryDetailView, IHistoryDetailContract.IHistoryDetailModel>(),
    IHistoryDetailContract.IHistoryDetailPresenter {
    override fun getDetailById(trajectoryId: String, context: Context) {
        val historyDis = mModel.getDetailById(trajectoryId)
            .compose(TransformUtil.defaultFlowableSchedulers())
            .compose(mView.bindToLife())
            .subscribe({
                val points = it.trajectoryPoints

                if (points != null) {
                    val pointList = ArrayList<LatLng>()
                    val bound = LatLngBounds.Builder()
                    points.forEach { point ->
                        val latLng = LatLng(point.latitude, point.longitude)
                        pointList.add(latLng)
                        bound.include(latLng)
                    }
                    //范围
                    mView.setBound(bound.build())
                    //线
                    val lineOptions = PolylineOptions().addAll(pointList).width(10f)
                        .color(ContextCompat.getColor(context, R.color.s_color_blue))
                    mView.displayHistoryTrajectory(lineOptions)

                    //开始结束点
                    val startMarker = MarkerOptions()
                        .position(pointList[0])
                        .icon(
                            BitmapDescriptorFactory.fromBitmap(
                                VectorUtil.vectorToBitmap(
                                    context,
                                    R.drawable.s_vector_start_location
                                )
                            )
                        )
                    val endMarker = MarkerOptions()
                        .position(pointList[pointList.size - 1])
                        .icon(
                            BitmapDescriptorFactory.fromBitmap(
                                VectorUtil.vectorToBitmap(
                                    context,
                                    R.drawable.s_vector_end_location
                                )
                            )
                        )
                    mView.displayStartEnd(startMarker, endMarker)
                }
                //运动数据
                val sportTime = it.sportTime
                val mileage = it.sportMileage
                val speed = "21.5"
                val climb = "555"
                val heat = it.heat
                mView.loadSportData(getMileageKm(mileage), speed, climb, TimeUtil.getTime(sportTime), heat.toString())
            }, { Logger.d(it.message) })
        mCompositeDisposable.add(historyDis)
    }

    private fun getMileageKm(mileage: Long): String {
        return String.format("%.2f", mileage / 1000f)
    }


}