package com.xu.module.wan.ui.activity.setting

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.utlis.extention.requestByNoResult
import com.xu.module.wan.api.WanService
import com.xu.module.wan.db.AppLiveData

class SettingViewModel @ViewModelInject constructor(
    private val api: WanService
) : BaseViewModel() {

    val loginStatus = AppLiveData.loginStatusLiveData
    /**
     * 登出结果
     */
    val logoutLiveData: MutableLiveData<Boolean> by lazy { MutableLiveData() }



    fun logout() {
        this.requestByNoResult({
            api.logout()
        }, {
            logoutLiveData.postValue(true)
            AppLiveData.loginStatus = false
        }, {
            logoutLiveData.postValue(false)
        })
    }
}