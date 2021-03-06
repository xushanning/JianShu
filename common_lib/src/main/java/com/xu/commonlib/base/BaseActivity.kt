package com.xu.commonlib.base

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.alibaba.android.arouter.launcher.ARouter
import com.jaeger.library.StatusBarUtil
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity
import com.xu.commonlib.R
import com.xu.commonlib.mvp.IBaseView
import com.xu.commonlib.utlis.extention.singleClick

/**
 * @author 言吾許
 */
abstract class BaseActivity : RxAppCompatActivity(),IBaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
        setContentView(setLayoutId())
        setStatusBar()
        val imgBack: ImageView? = findViewById(R.id.iv_back)
        imgBack?.singleClick {
            onBackClick()
        }

        initView(savedInstanceState)
        initData()
    }

    abstract fun setLayoutId(): Int
    /**
     * 设置沉浸式状态栏
     */
    open fun setStatusBar() {
        StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null)
    }


    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun initData()
    /**
     * 展示吐司
     */
    override fun showToast(content: String) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show()
    }

    open fun onBackClick() {
        finish()
    }
}