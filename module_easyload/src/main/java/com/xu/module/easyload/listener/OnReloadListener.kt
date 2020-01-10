package com.xu.module.easyload.listener

import android.view.View
import com.xu.module.easyload.service.ILoadService
import com.xu.module.easyload.state.BaseState
import java.io.Serializable

/**
 * @author xu
 */
interface OnReloadListener:Serializable {
    fun onReload(iLoadService: ILoadService, clickState: BaseState, view: View)
}
