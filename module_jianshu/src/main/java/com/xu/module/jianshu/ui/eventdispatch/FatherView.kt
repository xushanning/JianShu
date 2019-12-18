package com.xu.module.jianshu.ui.eventdispatch

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout
import com.orhanobut.logger.Logger

/**
 * 父容器view
 *
 * @author xu
 */
class FatherView : FrameLayout {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (ev?.action == MotionEvent.ACTION_DOWN) {
            Logger.d("父容器viewGroup dispatchTouchEvent")
        }
        return super.dispatchTouchEvent(ev)
    }

    /**
     * 可以这么认为：onInterceptTouchEvent返回值关系着是否调用onTouchListener
     * onTouchListener返回值关系着是否调用onTouchEvent
     * onTouchEvent返回值关系着是否调用onClickListener
     */
    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        if (ev?.action == MotionEvent.ACTION_DOWN) {
            Logger.d("父容器viewGroup onInterceptTouchEvent")
        }
        //容器拦截如果返回true，那么子view就收不到事件了，就会走自己的onTouchEvent方法
        return true
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN) {
            Logger.d("父容器viewGroup onTouchEvent")
        }
        //如果返回true，表示消费事件，不再往activity传递
        return super.onTouchEvent(event)
    }
}
