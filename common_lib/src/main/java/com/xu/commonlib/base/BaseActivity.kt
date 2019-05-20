package com.xu.commonlib.base

import android.os.Bundle
import com.jaeger.library.StatusBarUtil
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity
import com.xu.commonlib.mvp.IBaseView

/**
 * @author 言吾許
 */
abstract class BaseActivity : RxAppCompatActivity(), IBaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
        StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null)
    }

    abstract fun setLayoutId(): Int

    abstract fun initView()

    override fun showDialog(content: String) {
    }

    override fun showDialog() {
    }

    override fun showToast(content: String) {

    }

    override fun dismissDialog() {

    }
}