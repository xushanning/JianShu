package com.xu.module.jianshu.ui.easyload.state

import com.xu.module.easyload.state.BaseState
import com.xu.module.jianshu.R

/**
 * 默认的全局加载的状态
 */
class GlobalDefaultState : BaseState() {
    /**
     * 设置布局
     */
    override fun onCreateView(): Int {
        return R.layout.j_view_easy_load_global_default
    }
}