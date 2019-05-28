package com.xu.commonlib.base

import com.trello.rxlifecycle3.LifecycleTransformer
import com.xu.commonlib.di.component.AppComponent
import com.xu.commonlib.mvp.IPresenter
import com.xu.commonlib.mvp.IView
import javax.inject.Inject

/**
 * @author 言吾許
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseMvpActivity<in V : IView, P : IPresenter<V>> : BaseActivity(), IView {

    @Inject
    lateinit var mPresenter: P


    override fun initMvp() {
        initInject(BaseApplication.appComponent)
        mPresenter.attachView(this as V)
    }

    abstract fun initInject(appComponent: AppComponent)


    override fun <T> bindToLife(): LifecycleTransformer<T> {
        return this.bindToLifecycle()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}