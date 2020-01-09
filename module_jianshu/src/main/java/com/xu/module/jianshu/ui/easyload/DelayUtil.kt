package com.xu.module.jianshu.ui.easyload

import android.os.Handler
import android.os.Looper
import com.xu.module.easyload.service.ILoadService
import com.xu.module.easyload.state.BaseState
import com.xu.module.easyload.state.SuccessState

object DelayUtil {
    fun successDelay(loadService: ILoadService, delay: Long = 2000) {
        this.delay(loadService, SuccessState::class.java, delay)
    }

    fun delay(loadService: ILoadService, clState: Class<out BaseState>, delay: Long = 2000) {
        Handler(Looper.getMainLooper()).postDelayed(
                { loadService.showState(clState) }, delay)
    }
}