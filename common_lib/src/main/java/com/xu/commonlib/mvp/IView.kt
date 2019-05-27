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
}