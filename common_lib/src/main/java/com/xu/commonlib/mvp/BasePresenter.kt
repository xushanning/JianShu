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

    protected var mCompositeDisposable = CompositeDisposable()

    override fun attachView(mView: V) {
        this.mView = mView
    }

    override fun detachView() {
        mModel.onDetach()
        mCompositeDisposable.dispose()
    }

}