package com.xu.module.jianshu.ui.scroller

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.Scroller
import com.orhanobut.logger.Logger


/**
 * @author 许 on 2022/1/2.
 */
class MyScrollerView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val mPaint: Paint = Paint()
    private val mScroller: Scroller

    private var downX = 0f
    private var downY = 0f

    private var moveX = 0f
    private var moveY = 0f

    private var finalX = 0
    private var finalY = 0


    init {
        mPaint.textSize = 80f
        mScroller = Scroller(context)
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawText("我是中国人！", 0f, 100f, mPaint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                downX = event.x
                downY = event.y
            }
            MotionEvent.ACTION_MOVE -> {
                moveX = downX - event.x
                moveY = downY - event.y

            }
            MotionEvent.ACTION_UP -> {
                finalX = mScroller.finalX
                finalY = mScroller.finalY
                mScroller.startScroll(finalX, finalY, moveX.toInt(), moveY.toInt(), 3000)
                invalidate()
            }
        }

        return true
    }

    override fun computeScroll() {
        super.computeScroll()
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.currX, mScroller.currY)
            invalidate()
        }
    }
}