package com.xu.commonlib.mvp

import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleOwner
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

/**
 * @author 言吾許
 */
abstract class BasePresenter<V : IView, M : IModel> : IPresenter<V> {
    lateinit var mView: V
    lateinit var lifecycleScope: LifecycleCoroutineScope

    @Inject
    lateinit var mModel: M

    protected var mCompositeDisposable = CompositeDisposable()

    override fun attachView(mView: V, lifecycleScope: LifecycleCoroutineScope) {
        this.mView = mView
        this.lifecycleScope = lifecycleScope
    }

    override fun detachView() {
        mModel.onDetach()
        mCompositeDisposable.dispose()
    }

}