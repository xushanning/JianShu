package com.xu.commonlib.mvp

import com.trello.rxlifecycle3.LifecycleTransformer

/**
 * @author 言吾許
 */
interface IView : IBaseView {
    /**
     * 绑定声明周期
     */
    fun <T> bindToLife(): LifecycleTransformer<T>

    /**
     * 正在加载
     */
    fun showLoading()

    /**
     * 加载失败
     */
    fun showLoadFailed()

    /**
     * 暂无数据
     */
    fun showEmpty()
}