package com.xu.module.wan.constant.adapterconstant

import android.widget.ImageView
import androidx.databinding.BindingAdapter

/**
 * @author 许 on 2020/9/22.
 */
object ImageAdapterConstant {
    @JvmStatic
    @BindingAdapter("imgResId")
    fun loadImage(img: ImageView, resId: String) {
        val id = img.context.resources.getIdentifier(resId, "drawable", img.context.packageName)
        img.setImageResource(id)
    }
}