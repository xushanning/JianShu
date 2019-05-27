package com.xu.commonlib.base

import com.trello.rxlifecycle3.LifecycleTransformer
import com.xu.commonlib.mvp.IPresenter
import com.xu.commonlib.mvp.IView

/**
 * @author 言吾許
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseMvpActivity<in V : IView, P : IPresenter<V>> : BaseActivity(), IView {


    lateinit var mPresenter: P


    override fun initView() {
        mPresenter = setPresenter()
        mPresenter.attachView(this as V)

    }

    abstract fun setPresenter(): P


    override fun <T> bindToLife(): LifecycleTransformer<T> {
        return this.bindToLifecycle()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}