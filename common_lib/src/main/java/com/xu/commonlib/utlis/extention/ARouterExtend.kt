package com.xu.commonlib.utlis.extention

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter

/**
 * aRouter扩展
 */
fun navigate(path: String) {
    ARouter.getInstance().build(path).navigation()
}

fun navigate(path: String, func: Postcard.() -> Unit): Unit = run {
    ARouter.getInstance().build(path).with {
        this.func()
    }.navigation()
}

/**
 * 待返回的跳转
 */
fun navigate(path: String, activity: Activity, requestCode: Int) {
    ARouter.getInstance().build(path).navigation(activity, requestCode)
}

fun navigate(path: String, activity: Activity, requestCode: Int, func: Postcard.() -> Unit) {
    ARouter.getInstance().build(path).with {
        this.func()
    }.navigation(activity, requestCode)
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
