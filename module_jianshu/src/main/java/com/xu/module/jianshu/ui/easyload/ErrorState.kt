package com.xu.module.jianshu.ui.easyload

import com.xu.module.easyload.state.BaseState
import com.xu.module.jianshu.R

class ErrorState : BaseState() {
    /**
     * 设置布局
     */
    override fun onCreateView(): Int {
        return R.layout.j_activity_easy_load_error
    }

    override fun canReloadable(): Boolean {
        return true
    }

}