package com.xu.module.read.util

import android.graphics.Paint
import com.xu.module.read.widget.reader.ReaderView
import com.xu.module.read.widget.reader.SingleChar
import com.xu.module.read.widget.reader.SingleLine

/**
 * @author 许 on 2022/1/1.
 * 文字处理工具类
 * 用于处理
 */
object TextHandlerUtil {
    /**
     * 换行符
     */
    private val wrapSymbol = listOf("\n", "<br><br>", "<br>", "</p>")

    /**
     * 将段落处理成line对象
     */
    fun handleContentToLine(content: String, width: Float, paint: Paint): List<SingleLine> {
        var localContent = content
        val lines = arrayListOf<SingleLine>()
        while (localContent.isNotEmpty()) {
            val line = getCurLine(content.length - localContent.length, localContent.toCharArray(), width, paint)
            lines.add(line)
            localContent = localContent.substring(line.measureCount)
        }
        return lines
    }

    /**
     *@param startIndex 开始index
     * @param chars 字符串数组
     * @param totalWidth 一行的最大宽度
     * @param paint 画笔
     */
    private fun getCurLine(startIndex: Int, chars: CharArray, totalWidth: Float, paint: Paint): SingleLine {
        var width = 0f
        val line = SingleLine()
        chars.forEachIndexed { i, item ->
            //处理换行符
            if (item == '\n') {
                //下次循环从下一个换行符的下一个
                line.measureCount = i + 1
                return line
            }
            //char的长度
            val charWidth = paint.measureText(item.toString())
            if (width + charWidth + ReaderView.textPadding * 2 > totalWidth) {
                line.measureCount = i
                return line
            }

            val singleChar = SingleChar()
            singleChar.content = item
            singleChar.charWidth = charWidth
            line.chars.add(singleChar)
            width += charWidth
        }
        line.measureCount = chars.size
        return line
    }

    /**
     * @param pageHeight 页面的高度
     * @param lineSpace 行间距
     * @param paint 画笔
     */
    fun getMaxLineCount(pageHeight: Int, lineSpace: Float, paint: Paint): Int {
        val lineHeight = getTextHeight(paint) + lineSpace
        return (pageHeight / lineHeight).toInt()
    }

    /**
     * 获取画笔对应text的高度
     * @param paint 画笔
     */
    fun getTextHeight(paint: Paint): Float {
        val fm = paint.fontMetrics
        return fm.bottom - fm.top
    }

}