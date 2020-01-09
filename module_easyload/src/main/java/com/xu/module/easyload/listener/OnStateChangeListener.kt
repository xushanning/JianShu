package com.xu.module.easyload.listener

import android.view.View
import com.xu.module.easyload.state.BaseState

/**
 * 当前正在加载的state
 */
interface OnStateChangeListener {
    fun onStateChange(view: View, currentState: BaseState)
}