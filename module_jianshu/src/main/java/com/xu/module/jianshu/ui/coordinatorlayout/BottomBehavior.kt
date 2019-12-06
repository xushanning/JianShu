package com.xu.module.jianshu.ui.coordinatorlayout

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.xu.module.jianshu.R

class BottomBehavior(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<View>(context, attrs) {
    override fun layoutDependsOn(parent: CoordinatorLayout, child: View, dependency: View): Boolean {
        //依赖于headView
        return dependency.id == R.id.v_head
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout, child: View, dependency: View): Boolean {
        child.translationX = dependency.translationX + 200
        child.translationY = dependency.translationY + 200
        return true
    }
}