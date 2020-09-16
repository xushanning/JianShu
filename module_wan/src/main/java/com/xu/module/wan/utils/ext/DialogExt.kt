package com.xu.module.wan.utils.ext

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.callbacks.onCancel
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.customview.getCustomView
import com.afollestad.materialdialogs.lifecycle.lifecycleOwner
import com.xu.module.wan.R


/**
 * loading dialog
 */
private var loadingDialog: MaterialDialog? = null

/**
 * Fragment Dialog的扩展
 */
fun Fragment.showLoadingExt(msg: String) {
    this.activity?.let {
        showLoading(it, msg)
    }
}

/**
 * Activity Dialog的扩展
 */
fun AppCompatActivity.showLoadingExt(msg: String) {
    if (!this.isFinishing) {
        showLoading(this, msg)
    }
}

/**
 * 关闭dialog
 */
fun Fragment.dismissLoadingExt() {
    dismissDialog()
}

fun AppCompatActivity.dismissLoadingExt() {
    dismissDialog()
}

private fun dismissDialog() {
    loadingDialog?.dismiss()
    loadingDialog = null
}


private fun showLoading(context: FragmentActivity, msg: String) {
    if (loadingDialog == null) {
        loadingDialog = MaterialDialog(context)
            .cancelable(true)
            .cancelOnTouchOutside(false)
            .customView(R.layout.w_view_loading)
            .lifecycleOwner(context)
            .onCancel {
                loadingDialog = null
            }

    }
    loadingDialog?.getCustomView()?.run {
        val tvContent = findViewById<TextView>(R.id.tv_content)
        tvContent.text = msg
    }
    loadingDialog?.show()
}
