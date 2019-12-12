package com.xu.module.jianshu.ui.coordinatorlayout.sample3

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.viewpager.widget.ViewPager

/**
 * viewPager也是 依赖于textview
 */
class ContentBehavior(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<ViewPager>(context, attrs) {
    override fun layoutDependsOn(parent: CoordinatorLayout, child: ViewPager, dependency: View): Boolean {
        return dependency is TextView
    }


}