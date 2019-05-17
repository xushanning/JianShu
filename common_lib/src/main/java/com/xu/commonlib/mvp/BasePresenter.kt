package com.xu.commonlib.mvp

/**
 * @author 言吾許
 */
abstract class BasePresenter<V : IBaseView> : IBasePresenter<V> {
    lateinit var mView: V

    override fun attachView(mView: V) {
        this.mView = mView
    }

    override fun detachView() {

    }

}