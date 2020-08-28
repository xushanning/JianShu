package com.xu.commonlib.mvp

import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * @author 言吾許
 * 没有model的presenter
 */
//todo 怎么才能和basePresenter合并成一个，允许model为null的情况呢？
abstract class BaseNoModelPresenter<V : IView> : IPresenter<V> {
    lateinit var mView: V


    private var mCompositeDisposable: CompositeDisposable? = null

//    override fun attachView(mView: V) {
//        this.mView = mView
//    }

    override fun detachView() {

    }

}