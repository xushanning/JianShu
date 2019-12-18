package com.xu.module.jianshu.ui.eventdispatch

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout
import com.orhanobut.logger.Logger

/**
 * 根容器view
 *
 * @author xu
 */
class GrandfatherView : FrameLayout {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (ev?.action == MotionEvent.ACTION_DOWN) {
            Logger.d("根容器viewGroup dispatchTouchEvent")
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        if (ev?.action == MotionEvent.ACTION_DOWN) {
            Logger.d("根容器viewGroup onInterceptTouchEvent")
        }
        //容器拦截如果返回true，那么子view就收不到事件了，就会走自己的onTouchEvent方法
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN) {
            Logger.d("根容器viewGroup onTouchEvent")
        }
        //如果返回true，表示消费事件，不再往activity传递
        return super.onTouchEvent(event)
    }
}
