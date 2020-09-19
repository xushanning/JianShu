package com.xu.commonlib.base.mvvm

import androidx.lifecycle.MutableLiveData

/**
 * @author 许 on 2020/9/20.
 */
class AppLiveData private constructor() {
    companion object {
        val INSTANCE: AppLiveData by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            AppLiveData()
        }
    }

    val showDialog by lazy { MutableLiveData<String>() }

    val dismissDialog by lazy { MutableLiveData<Boolean>() }
}