package com.xu.commonlib.base.mvvm

import com.xu.commonlib.db.AppSp
import com.xu.commonlib.livedata.BooleanLiveData
import com.xu.commonlib.livedata.FloatLiveData
import com.xu.commonlib.livedata.IntLiveData

/**
 * 全局LiveData
 */
class AppLiveData private constructor() {

    companion object {
        val INSTANCE: AppLiveData by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            AppLiveData()
        }
    }

    /**
     * 夜间模式
     */
    val nightModeLiveData: BooleanLiveData by lazy {
        BooleanLiveData(AppSp.nightMode)
    }

    /**
     * 透明度
     */
    val nightAlphaLiveData: IntLiveData by lazy {
        IntLiveData((AppSp.nightAlpha * 100).toInt())
    }


}