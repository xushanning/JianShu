package com.xu.commonlib.base.mvvm

interface IBaseVmView {
    /**
     * 展示dialog
     */
    fun showLoading(msg: String)

    /**
     * 关闭dialog
     */
    fun dismissLoading()
}