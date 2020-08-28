package com.xu.commonlib.base

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initMvp()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    private fun initMvp() {
        mPresenter.attachView(this as V, lifecycleScope)
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
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show()
    }
}