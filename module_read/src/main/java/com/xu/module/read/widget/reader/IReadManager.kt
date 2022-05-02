package com.xu.module.read.widget.reader

import android.graphics.Canvas

/**
 * @author 许 on 2022/1/3.
 */
interface IReadManager {
    /**
     * 跳转上一页
     */
    fun toPrePage()

    /**
     * 跳转下一页
     */
    fun toNextPage()

    /**
     * 绘制页面
     */
    fun drawPage(canvas: Canvas?)
}