package com.xu.module.read.pagegesture

import android.content.Context
import android.graphics.Canvas
import android.view.MotionEvent
import android.view.VelocityTracker
import android.view.ViewConfiguration
import android.widget.Scroller
import com.orhanobut.logger.Logger
import kotlin.math.abs

/**
 * @author 许 on 2022/1/2.
 * 上下手势翻页处理类
 */
class UpDownPageGestureAdapter(context: Context) : PageGestureAdapter(context) {
    /**
     * 按下的Y轴值
     */
    private var downY = 0f


    private var finalY = 0

    private var velocityTracker: VelocityTracker? = null

    private var moveY = 0f

    /**
     * Y轴速度
     */
    private var velocityY: Float? = null

    private val minVelocityY: Int = ViewConfiguration.get(context).scaledMinimumFlingVelocity

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val y = event.y
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                velocityTracker = VelocityTracker.obtain()
                downY = y
            }
            MotionEvent.ACTION_MOVE -> {
                val moveY = y - downY
                scroller.startScroll(0, finalY, 0, moveY.toInt(), 0)
                pageDrawListener?.pageInvalidate()
                //将事件加入到VelocityTracker中
                velocityTracker?.addMovement(event)
                velocityTracker?.computeCurrentVelocity(1000)
                velocityY = velocityTracker?.yVelocity
            }
            else -> {
                finalY = scroller.finalY
                if (abs(velocityY!!) > minVelocityY) {
                    // scroller.fling(0, finalY, 0, velocityY!!.toInt(), 0, 0, -1000, 1000)
                }
                velocityTracker?.recycle()
                velocityTracker?.clear()
            }
        }
        pageDrawListener?.pageInvalidate()
        return true
    }

    override fun onDraw(canvas: Canvas?) {
        drawCurPage(canvas)
        drawNextPage(canvas)
    }

    override fun computeScroll() {
        //判断滚动动画是否结束,true：未结束，false：结束
        if (scroller.computeScrollOffset()) {
            // moveY = scroller.currX.toFloat()
            pageDrawListener?.pageInvalidate()
        } else {
            Logger.d("停止的位置" + scroller.currY)
        }
    }

    override fun abortAnimation() {
        if (!scroller.isFinished) {
            scroller.abortAnimation()
            finalY = scroller.currY
        }
    }

    /**
     * 绘制当前page
     */
    private fun drawCurPage(canvas: Canvas?) {
        //保存画布状态，之后可以调用平移缩放等功能
        canvas?.save()
        canvas?.translate(0f, scroller.currY.toFloat())
        //将创建的bitmap绘制到当前view的画布上去
        canvas?.drawBitmap(mCurrPageBitmap!!, 0f, 0f, null)
        //恢复保存的状态
        canvas?.restore()
    }

    /**
     * 绘制下一个page
     */
    private fun drawNextPage(canvas: Canvas?) {
        canvas?.save()
        canvas?.translate(0f, scroller.currY.toFloat() + width)
        canvas?.drawBitmap(mNextPageBitmap!!, 0f, 0f, null)
        canvas?.restore()
    }

}