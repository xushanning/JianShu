package com.xu.module.wan.base

import androidx.databinding.ViewDataBinding
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.base.mvvm.BaseVmFragment
import com.xu.module.wan.utils.ext.dismissLoadingExt
import com.xu.module.wan.utils.ext.showLoadingExt

/**
 * module中的BaseFragment
 * 把一些不同module可能不同的，如：loading交由module层确定
 */
abstract class BaseFragment<VM : BaseViewModel, DB : ViewDataBinding> : BaseVmFragment<VM, DB>() {

    override fun showLoading(msg: String) {
        showLoadingExt(msg)
    }

    override fun dismissLoading() {
        dismissLoadingExt()
    }
}