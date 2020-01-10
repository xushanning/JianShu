package com.xu.module.easyload.service

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


}