package com.xu.module.jianshu.ui.eventdispatch

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.orhanobut.logger.Logger

/**
 * 子view1
 */
class ChildView1 : View {
    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {}


    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN) {
            Logger.d("子view dispatchTouchEvent")
        }
        return super.dispatchTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN) {
            Logger.d("子view onTouchEvent")
        }
        //返回true代表此view消费了改事件，viewgroup和activity都不会调用onTouchEvent了
        //如果不调用 super.onTouchEvent(event)，那么就是直接重写了onTouchEvent，会导致，setOnClickListener没效果
        return super.onTouchEvent(event)
    }
}
