package com.xu.module.easyload.service

import com.xu.module.easyload.listener.OnStateChangeListener
import com.xu.module.easyload.listener.OnReloadListener
import com.xu.module.easyload.state.BaseState

interface ILoadService {
    /**
     * 成功
     */
    fun showSuccess()

    /**
     * 展示指定的状态
     */
    fun showState(clState: Class<out BaseState>)

    /**
     * 加载监听
     */
    fun setOnStateChangeListener(stateChangedListener: OnStateChangeListener): LoadService

    /**
     * 重新加载监听
     */
    fun setOnReloadListener(reloadListener: OnReloadListener): LoadService
}