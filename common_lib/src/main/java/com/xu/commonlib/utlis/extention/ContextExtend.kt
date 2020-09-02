package com.xu.commonlib.utlis.extention

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

/**
 * 吐司扩展
 */
fun Context.showToast(content: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, content, duration).show()
}

/**
 * 入参为resId
 */
fun Context.showToast(@StringRes resId: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, getString(resId), duration).show()
}