package com.xu.module.jianshu.ui.viewdraw

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewGroup
import android.widget.LinearLayout
import com.orhanobut.logger.Logger

/**
 * 父view
 */
class ParentView : LinearLayout {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // measureChildren(widthMeasureSpec, heightMeasureSpec)
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//        Logger.d(MeasureSpec.getSize(heightMeasureSpec))
//        when (MeasureSpec.getMode(heightMeasureSpec)) {
//            MeasureSpec.AT_MOST -> {
//                Logger.d("AT_MOST")
//            }
//            MeasureSpec.EXACTLY -> {
//                Logger.d("EXACTLY")
//            }
//            MeasureSpec.UNSPECIFIED -> {
//                Logger.d("UNSPECIFIED")
//            }
//            else -> {
//
//            }
//
//        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Logger.d("parentView ontouch" + event?.action)
        return true
    }


    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

//    override fun onDraw(canvas: Canvas?) {
//        super.onDraw(canvas)
//    }
}