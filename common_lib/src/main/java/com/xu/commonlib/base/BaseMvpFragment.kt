package com.xu.commonlib.base

import android.content.Context
import com.trello.rxlifecycle3.LifecycleTransformer
import com.xu.commonlib.mvp.IPresenter
import com.xu.commonlib.mvp.IView
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * @author 言吾許
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseMvpFragment<in V : IView, P : IPresenter<V>> : BaseFragment(), IView {
    @Inject
    lateinit var mPresenter: P

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun initMvp() {
        mPresenter.attachView(this as V)
    }


    override fun <T> bindToLife(): LifecycleTransformer<T> {
        return this.bindToLifecycle()
    }

    override fun showLoading() {

    }

    override fun showLoadFailed() {
    }

    override fun showEmpty() {
    }
}