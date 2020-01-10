package com.xu.module.easyload.listener

import android.view.View
import com.xu.module.easyload.state.BaseState
import java.io.Serializable

/**
 * 当前正在加载的state
 */
interface OnStateChangeListener : Serializable {
    fun onStateChange(view: View, currentState: BaseState)
}