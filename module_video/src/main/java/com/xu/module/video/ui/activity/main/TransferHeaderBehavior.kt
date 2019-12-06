package com.xu.module.video.ui.activity.main

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.orhanobut.logger.Logger

class TransferHeaderBehavior(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<TextView>(context, attrs) {
    /**
     * 处于中心时候原始X轴
     */
    private var mOriginalHeaderX = 0
    /**
     * 处于中心时候原始Y轴
     */
    private var mOriginalHeaderY = 0

    //使用该Behavior的View要监听哪个类型的View的状态变化
    override fun layoutDependsOn(parent: CoordinatorLayout, child: TextView, dependency: View): Boolean {
        return true
    }

    //依赖的是toolbar,所以这里的dependency其实是toolbar
    override fun onDependentViewChanged(parent: CoordinatorLayout, child: TextView, dependency: View): Boolean {
        Logger.d(dependency.y)
        //计算x轴
        if (mOriginalHeaderX == 0) {
            mOriginalHeaderX = dependency.width / 2 - child.width / 2
        }
        //计算y轴
        if (mOriginalHeaderY == 0) {
            mOriginalHeaderY = dependency.height - child.height
        }
        var mPercentX = dependency.y / mOriginalHeaderX
        if (mPercentX >= 1) {
            mPercentX = 1f
        }
        var mPercentY = dependency.y / mOriginalHeaderY
        if (mPercentY >= 1) {
            mPercentY = 1f
        }
        var x = mOriginalHeaderX - mOriginalHeaderX * mPercentX
        if (x <= child.width) {
            x = child.width.toFloat()
        }
        child.x = x
        child.y = mOriginalHeaderY - mOriginalHeaderY * mPercentY


        return true

    }
}