package com.xu.module.read.widget.reader

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.xu.module.read.R
import com.xu.module.read.pagegesture.PageGestureAdapter
import com.xu.module.read.pagegesture.UpDownPageGestureAdapter
import com.xu.module.read.util.PaintUtil

/**
 * @author 许 on 2021/12/31.
 */
class ReaderView(context: Context, attrs: AttributeSet) : View(context, attrs), OnPageDrawListener {
    /**
     *当前页
     */
    private var mCurrPageBitmap: Bitmap? = null

    /**
     * 下一页
     */
    private var mNextPageBitmap: Bitmap? = null

    private var mCurrPageCanvas: Canvas? = null
    private var mNextPageCanvas: Canvas? = null

    /**
     * 翻页手势处理器
     */
    private var pageGestureAdapter: PageGestureAdapter? = null

    /**
     * 阅读管理器
     */
    private var readManager: IReadManager? = null

    companion object {
        /**
         * 正文距离左边和右边的距离
         */
        const val textPadding = 20f
    }

    init {
        setDefaultPageGestureAdapter()
        initBg()
    }

    /**
     * 设置默认的手势处理器
     */
    private fun setDefaultPageGestureAdapter() {
        pageGestureAdapter = UpDownPageGestureAdapter(context)
    }

    /**
     * 初始化背景图片
     */
    private fun initBg() {
        val bgBitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.r_reader_bg)
        val shader = BitmapShader(bgBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT)
        val matrix = Matrix()
        shader.setLocalMatrix(matrix)
        val paint = PaintUtil.bgPaint
        paint.shader = shader
        paint.alpha = 120
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SCREEN)
        setBackgroundColor(resources.getColor(R.color.r_bg_1, null))
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (pageGestureAdapter != null && pageGestureAdapter!!.onTouchEvent(event)) {
            return true
        }
        return super.onTouchEvent(event)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        if (mCurrPageBitmap == null && mNextPageBitmap == null) {
            //创建一个和当前view一样大的bitmap
            mCurrPageBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888)
            mNextPageBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888)
            //根据bitmap创建一个画布
            mCurrPageCanvas = Canvas(mCurrPageBitmap!!)
            mNextPageCanvas = Canvas(mNextPageBitmap!!)
        }
        setPageGestureConfig()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //当前view绘制背景bitmap
        canvas?.drawPaint(PaintUtil.bgPaint)
        pageGestureAdapter?.onDraw(canvas)
    }

    override fun computeScroll() {
        super.computeScroll()
        pageGestureAdapter?.computeScroll()
    }


    override fun pageInvalidate() {
        postInvalidate()
    }

    override fun drawCurPage() {
        readManager?.drawPage(mCurrPageCanvas)
    }

    override fun drawNextPage() {
        readManager?.drawPage(mNextPageCanvas)
    }

    fun setReaderHandler() {
        val config = ReadConfig()
        config.apply {

            viewWidth = this@ReaderView.measuredWidth
            viewHeight = this@ReaderView.measuredHeight

        }
        val readHandler = ReadDrawHandler(config)
        readHandler.calculateParams()
        readHandler.drawPage(mCurrPageCanvas!!)
    }

    /**
     * 设置手势处理器
     */
    fun setPageGestureAdapter(pageGestureAdapter: PageGestureAdapter) {
        this.pageGestureAdapter = pageGestureAdapter
        setPageGestureConfig()
    }

    /**
     * 配置处理器
     */
    private fun setPageGestureConfig() {
        pageGestureAdapter?.initConfig(measuredWidth, measuredHeight, mCurrPageBitmap, mNextPageBitmap, this)
    }


}