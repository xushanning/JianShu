package com.xu.commonlib.base

import android.os.Bundle
import com.trello.rxlifecycle2.LifecycleTransformer
import com.xu.commonlib.mvp.IBaseMvpView
import com.xu.commonlib.mvp.IBasePresenter
import com.xu.commonlib.mvp.IBaseView
import javax.inject.Inject

/**
 * @author 言吾許
 */
abstract class BaseMvpActivity<P : IBasePresenter<IBaseView>> : BaseActivity(), IBaseMvpView {


    @Inject
    lateinit var mPresenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.attachView(this)

    }


    override fun <T> bindToLife(): LifecycleTransformer<T> {
        return this.bindToLifecycle()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}