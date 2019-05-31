package com.xu.commonlib.mvp

import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * @author 言吾許
 */
abstract class BasePresenter<V : IView, M : IModel> : IPresenter<V> {
    lateinit var mView: V
    @Inject
    lateinit var mModel: M

    private var mCompositeDisposable: CompositeDisposable? = null

    override fun attachView(mView: V) {
        this.mView = mView
        // this.mModel = setModel()
    }

//    abstract fun setModel(): M

    override fun detachView() {
        mModel.onDetach()
    }

}