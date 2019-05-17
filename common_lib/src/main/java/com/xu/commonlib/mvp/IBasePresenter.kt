package com.xu.commonlib.mvp

/**
 * @author 言吾許
 */
interface IBasePresenter<T : IBaseView> {
    fun attachView(mView: T)
    fun detachView()
}