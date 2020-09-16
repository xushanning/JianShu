package com.xu.module.wan.viewmodel

import androidx.lifecycle.MutableLiveData

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
     * 用户登录状态的LiveData
     */
    val loginStatusLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }

    /**
     * 网络状态的LiveData
     */


}