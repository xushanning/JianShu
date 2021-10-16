package com.xu.module.jianshu.ui.easyload.state


import com.xu.easyload.state.BaseState
import com.xu.module.jianshu.R

class ErrorState : BaseState() {
    /**
     * 设置布局
     */
    override fun onCreateView(): Int {
        return R.layout.j_view_easy_load_error
    }

    override fun canReloadable(): Boolean {
        return true
    }

}