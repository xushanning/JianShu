package com.xu.module.jianshu.ui.coordinatorlayout.sample3

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout

/**
 * header的behaviro
 */
class HeaderBehavior(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<View>(context, attrs) {

    companion object {
        /**
         * 状态打开
         */
        private const val STATUS_OPENED = 0
        /**
         * 状态关闭
         */
        private const val STATUS_CLOSED = 1
    }

}