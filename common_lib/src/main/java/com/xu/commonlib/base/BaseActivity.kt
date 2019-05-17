package com.xu.commonlib.base

import android.os.Bundle
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import com.xu.commonlib.mvp.IBaseView

/**
 * @author 言吾許
 */
abstract class BaseActivity : RxAppCompatActivity(), IBaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
    }

    abstract fun setLayoutId(): Int

    override fun showDialog(content: String) {
    }

    override fun showDialog() {
    }

    override fun showToast(content: String) {

    }

    override fun dismissDialog() {

    }
}