package com.xu.module.sport.ui.activity.historydetail

import android.content.Context
import com.amap.api.maps.model.LatLngBounds
import com.amap.api.maps.model.MarkerOptions
import com.amap.api.maps.model.PolylineOptions
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
        /**
         * 展示历史轨迹
         * @param lineOptions 线
         */
        fun displayHistoryTrajectory(lineOptions: PolylineOptions)

        /**
         * 加载运动数据
         * @param mileage 里程
         * @param speed 均速
         * @param climb 爬升
         * @param time 运动时间
         * @param heat 热度
         */
        fun loadSportData(mileage: String, speed: String, climb: String, time: String, heat: String)

        /**
         *展示开始、结束的点
         * @param startPoint 开始的点
         * @param endPoint 结束的点
         */
        fun displayStartEnd(startPoint: MarkerOptions, endPoint: MarkerOptions)

        /**
         * 设置范围
         */
        fun setBound(latLngBounds: LatLngBounds)
    }

    interface IHistoryDetailPresenter : IPresenter<IHistoryDetailView> {
        /**
         * 通过轨迹id获取运动的详情
         */
        fun getDetailById(trajectoryId: String, context: Context)
    }

    interface IHistoryDetailModel : IModel {
        fun getDetailById(trajectoryId: String): Flowable<TrajectoryEntity>
    }
}