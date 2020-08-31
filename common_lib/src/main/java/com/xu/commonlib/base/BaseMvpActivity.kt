package com.xu.commonlib.base


import android.os.Bundle
import com.trello.rxlifecycle3.LifecycleTransformer
import com.xu.commonlib.mvp.IPresenter
import com.xu.commonlib.mvp.IView
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 *           .----.
 *        _.'__    `.
 *    .--(Q)(OK)---/$\
 *  .' @          /$$$\
 *  :         ,   $$$$$
 *   `-..__.-' _.-\$$$/
 *         `;_:    `"'
 *       .'"""""`.
 *      /,  FLY  ,\
 *     //         \\
 *     `-._______.-'
 *     ___`. | .'___
 *    (______|______)
 *
 *@author 言吾
 */

@Suppress("UNCHECKED_CAST")
abstract class BaseMvpActivity<in V : IView, P : IPresenter<V>> : BaseActivity(), IView {

    @Inject
    lateinit var mPresenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        initMvp()
        super.onCreate(savedInstanceState)
    }

    private fun initMvp() {
        mPresenter.attachView(this as V)
    }

    override fun showLoading() {

    }

    override fun showLoadFailed() {
    }

    override fun showEmpty() {

    }

    /**
     *显示dialog
     */
    override fun showDialog(content: String) {

    }

    /**
     * 默认显示正在加载...
     */
    override fun showDialog() {
    }

    /**
     * 关闭dialog
     */
    override fun dismissDialog() {
    }


    override fun <T> bindToLife(): LifecycleTransformer<T> {
        return this.bindToLifecycle()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}