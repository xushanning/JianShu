package com.xu.module.wan.utils.ext

import android.app.Dialog
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.xu.module.wan.R


/**
 * loading dialog
 */
private var loadingDialog: Dialog? = null

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
    val view = LayoutInflater.from(context).inflate(R.layout.w_view_loading, null)
    val tvContent = view.findViewById<TextView>(R.id.tv_content)
    tvContent.text = msg
    if (loadingDialog == null) {
        loadingDialog = Dialog(context, R.style.wLoading)
        loadingDialog?.run {
            setCancelable(true)
            setCanceledOnTouchOutside(false)
            setContentView(view)
            setOnCancelListener {
                loadingDialog = null
            }
        }
    }
    loadingDialog?.show()
}
