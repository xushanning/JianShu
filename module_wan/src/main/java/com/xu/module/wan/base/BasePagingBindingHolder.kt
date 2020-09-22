package com.xu.module.wan.base

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

class BasePagingBindingHolder<BD : ViewDataBinding>(view: View) : BasePagingViewHolder(view) {
    val dataBinding = DataBindingUtil.bind<BD>(view)
}