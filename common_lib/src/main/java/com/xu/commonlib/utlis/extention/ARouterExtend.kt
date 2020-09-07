package com.xu.commonlib.utlis.extention

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.launcher.ARouter

/**
 * aRouter扩展
 */
fun go(path: String) {
    ARouter.getInstance().build(path).navigation()
}

fun go(path: String, func: Postcard.() -> Unit): Unit = run {
    ARouter.getInstance().build(path).with {
        this.func()
    }.navigation()
}

private fun Postcard.with(func: Postcard.() -> Unit): Postcard = run {
    this.func()
    return this
}

/**
 * 获取Fragment
 */
fun getFragment(path: String): Fragment {
    return ARouter.getInstance()
        .build(path)
        .navigation() as Fragment
}

fun getFragment(path: String, func: Postcard.() -> Unit): Fragment {
    return ARouter.getInstance()
        .build(path)
        .with {
            this.func()
        }
        .navigation() as Fragment
}
