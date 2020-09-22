package com.xu.commonlib.utlis

import android.graphics.Color

object ColorUtil {
    /**
     * 获取随机颜色
     */
    fun getRandomColor(): Int {
        val red = (0..190).random()
        val green = (0..190).random()
        val blue = (0..190).random()
        return Color.rgb(red, green, blue)
    }
}