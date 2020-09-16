package com.xu.module.wan.weight.state

import android.content.Context
import android.view.View
import android.widget.TextView
import com.xu.easyload.state.BaseState
import com.xu.module.wan.R

/**
 * 加载status
 */
class LoadingState : BaseState() {
    override fun onCreateView(): Int {
        return R.layout.w_view_loading
    }

    override fun attachView(context: Context, view: View) {
        val tvContent = view.findViewById<TextView>(R.id.tv_content)
        tvContent.text = "正在加载.."
    }
}