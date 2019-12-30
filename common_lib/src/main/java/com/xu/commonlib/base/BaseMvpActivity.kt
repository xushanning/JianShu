package com.xu.commonlib.base


import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.trello.rxlifecycle3.LifecycleTransformer
import com.xu.commonlib.mvp.IPresenter
import com.xu.commonlib.mvp.IView
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
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
abstract class BaseMvpActivity<in V : IView, P : IPresenter<V>> : BaseActivity(), IView,
    HasSupportFragmentInjector {

    @Inject
    lateinit var mPresenter: P

    @Inject
    lateinit var supportFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        initMvp()
        super.onCreate(savedInstanceState)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return supportFragmentInjector
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

    /**
     * 展示吐司
     */
    override fun showToast(content: String) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show()
    }

    override fun <T> bindToLife(): LifecycleTransformer<T> {
        return this.bindToLifecycle()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}