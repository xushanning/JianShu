package com.xu.module.wan.weight.state

import com.xu.easyload.state.BaseState
import com.xu.module.wan.R

/**
 * 加载status
 */
class LoadingState : BaseState() {
    override fun onCreateView(): Int {
        return R.layout.w_view_loading
    }
}