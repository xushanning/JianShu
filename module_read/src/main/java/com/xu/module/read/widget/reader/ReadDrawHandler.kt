package com.xu.module.read.widget.reader

import android.graphics.Canvas
import com.xu.commonlib.utlis.AssetUtil
import com.xu.module.read.util.PaintUtil
import com.xu.module.read.util.TextHandlerUtil

/**
 * @author 许 on 2022/1/3.
 * 阅读处理器
 */
class ReadDrawHandler(private val readConfig: ReadConfig) {

    /**
     * 所有的行
     */
    private var singleLines: List<SingleLine>? = null

    /**
     * 一页能展示多少行
     */
    private var maxLineCount = 0

    /**
     * 当前总页数
     */
    private var sumPage = 0

    fun calculateParams() {
        //能绘制的最大宽度
        val usableWidth = readConfig.viewWidth - readConfig.padding[2] - readConfig.padding[3]
        val usableHeight = readConfig.viewHeight - readConfig.padding[0] - readConfig.padding[1]
        maxLineCount = TextHandlerUtil.getMaxLineCount(readConfig.viewWidth, readConfig.lineSpace, PaintUtil.bodyPaint)

        //计算多少行
        singleLines = TextHandlerUtil.handleContentToLine(AssetUtil.getAssetJson("斗破.txt"), readConfig.viewWidth + 0f, PaintUtil.bodyPaint)
        //计算多少页


    }

    /**
     * 绘制页面
     */
    fun drawPage(canvas: Canvas) {

        if (singleLines != null) {
            drawBody(canvas)
        }
    }

    /**
     * 绘制正文
     */
    private fun drawBody(canvas: Canvas) {
        var startY = 100f
        val fm = PaintUtil.bodyPaint.fontMetrics
        val height = fm.bottom - fm.top
        singleLines?.forEach {
            drawLine(it, ReaderView.textPadding, startY, canvas)
            startY += height
        }
    }


    /**
     * 绘制单行
     */
    private fun drawLine(line: SingleLine, x: Float, y: Float, canvas: Canvas) {
        var start = x
        line.chars.forEach {
            canvas.drawText(it.content.toString(), start, y, PaintUtil.bodyPaint)
            start += it.charWidth
        }
    }


}