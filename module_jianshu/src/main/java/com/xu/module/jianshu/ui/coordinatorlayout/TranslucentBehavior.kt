package com.xu.module.jianshu.ui.coordinatorlayout

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.TextView

import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout

class TranslucentBehavior(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<Toolbar>(context, attrs) {
    private var mToolbarHeight = 0

    override fun layoutDependsOn(parent: CoordinatorLayout, child: Toolbar, dependency: View): Boolean {
        return dependency is TextView
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout, child: Toolbar, dependency: View): Boolean {
        /**
         *  初始化高度
         */
        if (mToolbarHeight == 0) {
            mToolbarHeight = child.bottom * 2
        }
        //计算toolbar从开始移动到最后的百分比
        var percent = dependency.y / mToolbarHeight
        if (percent >= 1) {
            percent = 1f
        }
        val alpha = percent * 255
        child.setBackgroundColor(Color.argb(alpha.toInt(), 63, 81, 181))
        return true
    }
}
