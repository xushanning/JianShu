package com.xu.module.read.pagegesture

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.MotionEvent
import android.widget.Scroller
import com.xu.module.read.widget.reader.OnPageDrawListener

/**
 * @author 许 on 2022/1/2.
 * 翻页手势处理
 * 决定当前页和下一页的相对位置
 */
abstract class PageGestureAdapter(context: Context) {
    protected var mCurrPageBitmap: Bitmap? = null
    protected var mNextPageBitmap: Bitmap? = null
    protected var pageDrawListener: OnPageDrawListener? = null

    protected var scroller: Scroller = Scroller(context)

    /**
     * view的宽度
     */
    protected var width = 0

    /**
     * view的高度
     */
    protected var height = 0


    /**
     * 初始化配置
     * @param width view的宽度
     * @param height view的高度
     */
    fun initConfig(width: Int, height: Int, mCurrPageBitmap: Bitmap?, mNextPageBitmap: Bitmap?, pageDrawListener: OnPageDrawListener) {
        this.width = width
        this.height = height
        this.mCurrPageBitmap = mCurrPageBitmap
        this.mNextPageBitmap = mNextPageBitmap
        this.pageDrawListener = pageDrawListener
    }

    /**
     * 手势处理
     */
    abstract fun onTouchEvent(event: MotionEvent): Boolean

    /**
     * 处理绘制
     */
    abstract fun onDraw(canvas: Canvas?)

    /**
     *透传view的computeScroll()
     */
    abstract fun computeScroll()

    abstract fun abortAnimation()
}