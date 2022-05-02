package com.xu.module.read.util

import android.graphics.Color
import android.graphics.Paint

/**
 * @author 许 on 2022/1/1.
 * 画笔工具类
 */
object PaintUtil {
    /**
     * 正文画笔
     */
    val bodyPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    /**
     * 标题画笔
     */
    val titlePaint = Paint(Paint.ANTI_ALIAS_FLAG)

    /**
     * 绘制页面画笔
     */
    val bgPaint = Paint()

    init {
        bodyPaint.textSize = 60f
        bodyPaint.color = Color.BLACK
    }
}