package com.xu.module.wan.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import com.xu.commonlib.base.BaseApplication
import com.xu.module.wan.R

object ImgObj {
    @JvmStatic
    @BindingAdapter("roundUrl")
    fun loadRoundImg(img: ImageView, url: String) {
        if (url.isEmpty()) {
            Glide.with(BaseApplication.appContext.applicationContext).load(R.drawable.w_android)
                .apply(RequestOptions.circleCropTransform()).into(img);
        } else {
            Glide.with(BaseApplication.appContext.applicationContext).load(url)
                .apply(RequestOptions.circleCropTransform()).into(img);
        }
    }
}