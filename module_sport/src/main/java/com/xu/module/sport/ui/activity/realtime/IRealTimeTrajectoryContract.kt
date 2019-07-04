package com.xu.module.sport.ui.activity.realtime

import android.content.Context
import android.view.animation.AlphaAnimation
import com.amap.api.maps.model.LatLng
import com.amap.api.maps.model.MarkerOptions
import com.amap.api.maps.model.PolylineOptions
import com.xu.commonlib.mvp.IModel
import com.xu.commonlib.mvp.IPresenter
import com.xu.commonlib.mvp.IView

/**
 * @author 言吾許
 */
interface IRealTimeTrajectoryContract {
    interface IRealTimeTrajectoryView : IView {
        fun sportStarted()

        fun sportStopped()
        /**
         * 展示运动轨迹
         */
        fun displayTrajectory(lineOptions: PolylineOptions)

        /**
         * 绘制开始点
         * @param startOption 开始点
         * @param currentOption 当前点
         */
        fun displayStartPoint(startOption: MarkerOptions, currentOption: MarkerOptions)


        /**
         * 平滑移动当前位置
         */
        fun smoothMove(movePoint: List<LatLng>)

        /**
         * 刷新时间
         * @param speed 速度
         * @param sportTime 运动时间
         */
        fun refreshDashBoard(sportTime: String, speed: String)

        /**
         * 开启暂停的闪烁动画
         */
        fun startAnimator(animator: AlphaAnimation)

        /**
         * 更新activity中最新的点位
         */
        fun latestPoint(point: LatLng)
    }

    interface IRealTimeTrajectoryPresenter : IPresenter<IRealTimeTrajectoryView> {
        /**
         * 开始运动
         */
        fun startSport(context: Context)

        /**
         * 结束运动
         */
        fun stopSport(context: Context)
    }

    interface IRealTimeTrajectoryModel : IModel {

    }
}