package com.xu.commonlib.utlis.extention

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.xu.commonlib.base.BaseApplication

/**
 * 图片加载扩展
 */
fun ImageView.load(url: String) {
    Glide.with(BaseApplication.appContext.applicationContext)
            .load(url)
            .into(this)
}
