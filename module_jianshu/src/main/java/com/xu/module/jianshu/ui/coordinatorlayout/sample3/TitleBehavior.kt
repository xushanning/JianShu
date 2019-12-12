package com.xu.module.jianshu.ui.coordinatorlayout.sample3

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.tabs.TabLayout

/**
 * title也是 依赖于textview
 */
class TitleBehavior(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<LinearLayout>(context, attrs) {


    override fun layoutDependsOn(parent: CoordinatorLayout, child: LinearLayout, dependency: View): Boolean {
        return dependency is TextView
    }


}