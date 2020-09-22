package com.xu.module.wan.base

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

class BaseDataBindingHolder<BD : ViewDataBinding>(view: View) : BaseViewHolder(view) {
    val dataBinding = DataBindingUtil.bind<BD>(view)
}