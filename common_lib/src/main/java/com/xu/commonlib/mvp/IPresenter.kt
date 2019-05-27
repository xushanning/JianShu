package com.xu.commonlib.mvp

/**
 * @author 言吾許
 */
interface IPresenter<in T : IView> {
    fun attachView(mView: T)
    fun detachView()
}