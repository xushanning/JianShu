package com.xu.module.jianshu.ui.viewdraw

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.orhanobut.logger.Logger

/**
 * 子view
 */
class ChildView : View {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Logger.d("child onTouch")
        return false
    }

}