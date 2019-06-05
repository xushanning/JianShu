package com.xu.commonlib.base

import android.os.Bundle
import android.widget.ImageView
import com.jaeger.library.StatusBarUtil
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity
import com.xu.commonlib.R
import com.xu.commonlib.mvp.IBaseView
import com.xu.commonlib.utlis.extention.singleClick

/**
 * @author 言吾許
 */
abstract class BaseActivity : RxAppCompatActivity(), IBaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
        setStatusBar()
        val imgBack: ImageView? = findViewById(R.id.iv_back)
        imgBack?.singleClick {
            onBackClick()
        }
        initMvp()
        initView(savedInstanceState)
    }

    abstract fun setLayoutId(): Int
    /**
     * 设置沉浸式状态栏
     */
    open fun setStatusBar() {
        StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null)
    }

    open fun initMvp() {

    }

    abstract fun initView(savedInstanceState: Bundle?)

    open fun onBackClick() {
        finish()
    }

    override fun showDialog(content: String) {
    }

    override fun showDialog() {
    }

    override fun showToast(content: String) {

    }

    override fun dismissDialog() {

    }
}