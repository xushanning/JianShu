package com.xu.module.wan.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter

object TextViewObj {
    @JvmStatic
    @BindingAdapter("num")
    fun setText(tv: TextView, num: Int) {
        tv.text = num.toString()
    }
}