package com.xu.module.jianshu.ui.easyload

import com.xu.module.easyload.state.BaseState
import com.xu.module.jianshu.R

class LoadingState : BaseState() {
    /**
     * 设置布局
     */
    override fun onCreateView(): Int {
        return R.layout.j_activity_easy_load_loading
    }

    override fun canReloadable(): Boolean {
        return true
    }

}