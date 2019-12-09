package com.xu.module.jianshu.ui.coordinatorlayout.sample1

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewBehavior(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<RecyclerView>(context, attrs) {


    override fun layoutDependsOn(parent: CoordinatorLayout, child: RecyclerView, dependency: View): Boolean {
        return dependency is TextView
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout, child: RecyclerView, dependency: View): Boolean {
        var y = dependency.height + dependency.translationY
        if (y < 0) {
            y = 0f
        }
        child.y = y
        return true
    }

}