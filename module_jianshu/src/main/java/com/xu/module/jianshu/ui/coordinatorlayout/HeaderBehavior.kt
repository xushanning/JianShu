package com.xu.module.jianshu.ui.coordinatorlayout

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout

class HeaderBehavior(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<View>(context, attrs) {
    override fun onTouchEvent(parent: CoordinatorLayout, child: View, ev: MotionEvent): Boolean {
        if(ev.action== MotionEvent.ACTION_MOVE){
            child.translationY = ev.rawY
            child.translationX=ev.rawX
        }
        return true
    }
}