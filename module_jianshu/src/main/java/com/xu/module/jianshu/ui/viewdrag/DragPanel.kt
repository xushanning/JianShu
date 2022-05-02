package com.xu.module.jianshu.ui.viewdrag

import android.content.Context
import android.graphics.Point
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.get
import androidx.customview.widget.ViewDragHelper
import com.orhanobut.logger.Logger
import kotlin.math.max
import kotlin.math.min

/**
 * @author 许 on 2021/12/11.
 */
internal class DragPanel(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    /**
     *只让view在内部移动
     */
//    private var drag: ViewDragHelper =
//        ViewDragHelper.create(this, 1.0f, InnerCallback(this))
    /**
     * 可回弹的view的初始位置
     */
    private val mAutoBackOriginPos = Point()
    private lateinit var drag: ViewDragHelper

    init {
        drag =
            ViewDragHelper.create(this, 1.0f, object : ViewDragHelper.Callback() {
                override fun tryCaptureView(child: View, pointerId: Int): Boolean {
                    //只有这两个view可以拖动，其他禁止
                    return child == mDragView || child == mAutoBackView
                }

                override fun clampViewPositionVertical(child: View, top: Int, dy: Int): Int {

                    return top
                }



                /**
                 * 当释放view的时候会调用
                 */
                override fun onViewReleased(releasedChild: View, xvel: Float, yvel: Float) {
                    if (releasedChild == mAutoBackView) {
                        //释放会自动弹回去，需要invalidate()以及结合computeScroll方法一起。
                        drag.settleCapturedViewAt(mAutoBackOriginPos.x, mAutoBackOriginPos.y)
                        invalidate()
                    }
                }

                override fun onEdgeDragStarted(edgeFlags: Int, pointerId: Int) {
                    //该方法可以绕过tryCaptureView
                    drag.captureChildView(mEdgeTrackerView!!, pointerId)
                }

                //如果view设置了点击事件，需要重写这个方法
                override fun getViewHorizontalDragRange(child: View): Int {
                    return measuredWidth - child.measuredWidth;
                }

                override fun getViewVerticalDragRange(child: View): Int {
                    return measuredHeight - child.measuredHeight
                }

                //当ViewDragHelper状态发生变化时回调（IDLE,DRAGGING,SETTING[自动滚动时]）
                override fun onViewDragStateChanged(state: Int) {
                    super.onViewDragStateChanged(state)
                }

                //当captureview的位置发生改变时回调
                override fun onViewPositionChanged(changedView: View, left: Int, top: Int, dx: Int, dy: Int) {
                    super.onViewPositionChanged(changedView, left, top, dx, dy)
                }

                //当captureview被捕获时回调
                override fun onViewCaptured(capturedChild: View, activePointerId: Int) {
                    super.onViewCaptured(capturedChild, activePointerId)
                }

                //当触摸到边界时回调。
                override fun onEdgeTouched(edgeFlags: Int, pointerId: Int) {
                    super.onEdgeTouched(edgeFlags, pointerId)
                }

                //true的时候会锁住当前的边界，false则unLock。
                override fun onEdgeLock(edgeFlags: Int): Boolean {
                    return super.onEdgeLock(edgeFlags)
                }

                //改变同一个坐标（x,y）去寻找captureView位置的方法。（具体在：findTopChildUnder方法中）
                override fun getOrderedChildIndex(index: Int): Int {
                    return super.getOrderedChildIndex(index)
                }

            })
        //
        drag.setEdgeTrackingEnabled(ViewDragHelper.EDGE_LEFT)
    }


    private var mDragView: View? = null
    private var mAutoBackView: View? = null
    private var mEdgeTrackerView: View? = null

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return drag.shouldInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        drag.processTouchEvent(event)
        return true
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        mAutoBackOriginPos.x = mAutoBackView!!.left
        mAutoBackOriginPos.y = mAutoBackView!!.right
    }

    override fun computeScroll() {
        if (drag.continueSettling(true)) {
            invalidate()
        }
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        mDragView = getChildAt(0)
        mDragView!!.setOnClickListener {


        }
        mAutoBackView = getChildAt(1)
        mEdgeTrackerView = getChildAt(2)
    }

}