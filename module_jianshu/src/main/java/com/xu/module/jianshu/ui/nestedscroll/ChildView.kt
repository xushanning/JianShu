package com.xu.module.jianshu.ui.nestedscroll

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.ListView
import androidx.core.view.NestedScrollingChild2
import androidx.core.view.NestedScrollingChildHelper
import androidx.core.view.ViewCompat

/**
 * 嵌套滑动子view
 */
class ChildView : ListView, NestedScrollingChild2 {

    private var mChildHelper = NestedScrollingChildHelper(this)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        //首先得允许嵌套滑动，否则，不起作用，因为NestedScrollingChildHelper 回去校验这个参数
        isNestedScrollingEnabled = true
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            //按下的时候，调用该方法，去判断父控件是否支持嵌套滑动
            startNestedScroll(ViewCompat.SCROLL_AXIS_VERTICAL)
        }
        return super.onTouchEvent(event)
    }

    /**
     * 开启一个嵌套滑动
     * @param axes 支持的嵌套滑动方法，分为水平方向，竖直方向
     * @return 如果返回true 那么说明已经找到了一套嵌套滑动的view
     */
    override fun startNestedScroll(axes: Int, type: Int): Boolean {
        return mChildHelper.startNestedScroll(axes, type)
    }

    override fun startNestedScroll(axes: Int): Boolean {
        return mChildHelper.startNestedScroll(axes)
    }

    /**
     * 当父控件消耗事件后，子控件处理后，又继续将事件分发给父控件,由父控件判断是否消耗剩下的距离。
     * @param dxConsumed     水平方向嵌套滑动的子控件滑动的距离(消耗的距离)
     * @param dyConsumed     垂直方向嵌套滑动的子控件滑动的距离(消耗的距离)
     * @param dxUnconsumed   水平方向嵌套滑动的子控件未滑动的距离(未消耗的距离)
     * @param dyUnconsumed   垂直方向嵌套滑动的子控件未滑动的距离(未消耗的距离)
     * @param offsetInWindow 子控件在当前window的偏移量
     * @return 如果返回true, 表示父控件又继续消耗了
     */
    override fun dispatchNestedScroll(dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, offsetInWindow: IntArray?, type: Int): Boolean {
        return mChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type)
    }

    override fun dispatchNestedScroll(dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, offsetInWindow: IntArray?): Boolean {
        return mChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow)
    }

    override fun isNestedScrollingEnabled(): Boolean {
        return mChildHelper.isNestedScrollingEnabled
    }

    /**
     * 在滑动之前，将事件分发给父控件，由父控件判断消耗多少
     * @param dx  水平方向嵌套滑动的子控件想要变化的距离 dx<0 向右滑动 dx>0 向左滑动
     * @param dy  垂直方向嵌套滑动的子控件想要变化的距离 dy<0 向下滑动 dy>0 向上滑动
     * @param consumed 子控件传给父控件数组，用于存储父控件水平与竖直方向上消耗的距离，consumed[0] 水平消耗的距离，consumed[1] 垂直消耗的距离
     * @param offsetInWindow 子控件在当前window的偏移量
     * @return 如果返回true, 表示父控件已经消耗了
     */
    override fun dispatchNestedPreScroll(dx: Int, dy: Int, consumed: IntArray?, offsetInWindow: IntArray?, type: Int): Boolean {
        return mChildHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow, type)
    }

    override fun dispatchNestedPreScroll(dx: Int, dy: Int, consumed: IntArray?, offsetInWindow: IntArray?): Boolean {
        return mChildHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow)
    }

    /**
     * 子控件停止嵌套滑动
     */
    override fun stopNestedScroll(type: Int) {
        mChildHelper.stopNestedScroll(type)
    }

    override fun stopNestedScroll() {
        mChildHelper.stopNestedScroll()
    }

    override fun hasNestedScrollingParent(type: Int): Boolean {
        return mChildHelper.hasNestedScrollingParent(type)
    }

    override fun hasNestedScrollingParent(): Boolean {
        return mChildHelper.hasNestedScrollingParent()
    }


    /**
     * 设置当前子控件是否支持嵌套滑动，如果不支持，那么父控件是不能够响应嵌套滑动的
     */
    override fun setNestedScrollingEnabled(enabled: Boolean) {
        mChildHelper.isNestedScrollingEnabled = enabled
    }

    /**
     * 当子控件产生fling滑动时，判断父控件是否处拦截fling，如果父控件处理了fling，那子控件就没有办法处理fling了。
     *  @param velocityX 水平方向上的速度 velocityX > 0  向左滑动，反之向右滑动
     *  @param velocityY 竖直方向上的速度 velocityY > 0  向上滑动，反之向下滑动
     *  @return 如果返回true, 表示父控件拦截了fling
     */
    override fun dispatchNestedPreFling(velocityX: Float, velocityY: Float): Boolean {
        return mChildHelper.dispatchNestedPreFling(velocityX, velocityY)
    }

    /**
     * 当父控件不拦截子控件的fling,那么子控件会调用该方法将fling，传给父控件进行处理
     * @param velocityX 水平方向上的速度 velocityX > 0  向左滑动，反之向右滑动
     * @param consumed  子控件是否可以消耗该fling，也可以说是子控件是否消耗掉了该fling
     * @param velocityY 竖直方向上的速度 velocityY > 0  向上滑动，反之向下滑动
     * @return 父控件是否消耗了该fling
     */
    override fun dispatchNestedFling(velocityX: Float, velocityY: Float, consumed: Boolean): Boolean {
        return mChildHelper.dispatchNestedFling(velocityX, velocityY, consumed)
    }

}