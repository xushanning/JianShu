package com.xu.module.jianshu.ui.coordinatorlayout.sample3

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.tabs.TabLayout

/**
 * tab 依赖于textview
 */
class TabBehavior(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<TabLayout>(context, attrs) {


    override fun layoutDependsOn(parent: CoordinatorLayout, child: TabLayout, dependency: View): Boolean {
        return dependency is TextView
    }


}