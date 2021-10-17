package com.xu.module.read.base

import androidx.databinding.ViewDataBinding
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.base.mvvm.BaseVmActivity


/**
 * module中的BaseActivity
 * 把一些不同module可能不同的，如：loading交由module层确定
 */
abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding> : BaseVmActivity<VM, DB>() {


    override fun showLoading(msg: String) {
        //showLoadingExt(msg)
    }

    override fun dismissLoading() {
        //dismissLoadingExt()
    }
}