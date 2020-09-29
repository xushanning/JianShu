package com.xu.module.wan.viewmodel

import androidx.lifecycle.MutableLiveData
import com.xu.module.wan.db.WanSp

/**
 * 全局LiveData
 */
class WanLiveData private constructor() {

    companion object {
        val INSTANCE: WanLiveData by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            WanLiveData()
        }
    }


    /**
     * 用户登录状态的LiveData
     */
    val loginStateLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(WanSp.loginState)
    }

    /**
     * 网络状态的LiveData
     */


}