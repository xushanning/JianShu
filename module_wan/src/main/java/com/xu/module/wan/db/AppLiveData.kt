package com.xu.module.wan.db

import androidx.lifecycle.MutableLiveData

object AppLiveData {
    /**
     * 当前的用户状态
     */
    private var currentStatus = false

    val loginStatusLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }

    /**
     * 带有LiveData的登陆状态
     */
    var loginStatus: Boolean
        get() {
            return currentStatus
        }
        set(status) {
            currentStatus = status
            loginStatusLiveData.postValue(status)
        }
}