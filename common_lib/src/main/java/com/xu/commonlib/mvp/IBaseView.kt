package com.xu.commonlib.mvp

/**
 * @author 言吾許
 */
interface IBaseView {

    /**
     *显示dialog
     */
    fun showDialog(content: String)

    /**
     * 默认显示正在加载...
     */
    fun showDialog()

    /**
     * 关闭dialog
     */
    fun dismissDialog()

    /**
     * 展示吐司
     */
    fun showToast(content: String)

}