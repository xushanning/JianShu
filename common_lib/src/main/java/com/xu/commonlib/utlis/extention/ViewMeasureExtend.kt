package com.xu.commonlib.utlis.extention

import android.view.View
import android.view.ViewTreeObserver

/**
 * @author 言吾許
 * view测量extend
 */

inline fun <T : View> T.afterMeasured(crossinline f: T.() -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            if (measuredWidth > 0 && measuredHeight > 0) {
                f()
                viewTreeObserver.removeOnGlobalLayoutListener(this)
            }
        }

    })
}