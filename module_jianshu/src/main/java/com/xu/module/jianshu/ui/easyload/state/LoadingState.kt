package com.xu.module.jianshu.ui.easyload.state

import com.xu.module.easyload.state.BaseState
import com.xu.module.jianshu.R

class LoadingState : BaseState() {
    /**
     * 设置布局
     */
    override fun onCreateView(): Int {
        return R.layout.j_view_easy_load_loading
    }



}