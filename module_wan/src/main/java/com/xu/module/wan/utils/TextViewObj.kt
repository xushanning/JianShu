package com.xu.module.wan.utils

import android.graphics.Color
import android.widget.TextView
import androidx.databinding.BindingAdapter

object TextViewObj {
    @JvmStatic
    @BindingAdapter("num")
    fun setText(tv: TextView, num: Int) {
        tv.text = num.toString()
    }

    /**
     * 给TextView随机颜色
     */
    @JvmStatic
    @BindingAdapter("colorText")
    fun setRandomColor(tv: TextView, content: String) {
        val red = (0..190).random()
        val green = (0..190).random()
        val blue = (0..190).random()
        val color = Color.rgb(red, green, blue)
        tv.setTextColor(color)
        tv.text = content
    }
}