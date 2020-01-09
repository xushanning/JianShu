package com.xu.module.easyload.listener

import android.view.View
import com.xu.module.easyload.service.ILoadService
import com.xu.module.easyload.state.BaseState

/**
 * @author xu
 */
interface OnReloadListener {
    fun onReload(iLoadService: ILoadService, clickState: BaseState, view: View)
}
