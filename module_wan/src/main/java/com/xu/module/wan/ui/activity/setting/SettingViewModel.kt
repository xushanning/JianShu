package com.xu.module.wan.ui.activity.setting

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.utlis.extention.requestByNoResult
import com.xu.module.wan.api.WanService
import com.xu.module.wan.viewmodel.AppLiveData

class SettingViewModel @ViewModelInject constructor(
    private val api: WanService,
    private val appLiveData: AppLiveData
) : BaseViewModel() {

    val loginStatus = appLiveData.loginStatusLiveData

    /**
     * 登出结果
     */
    val logoutLiveData: MutableLiveData<Boolean> by lazy { MutableLiveData() }


    fun logout() {
        this.requestByNoResult({
            api.logout()
        }, {
            //更新登出结果
            logoutLiveData.postValue(true)
            //更新全局登录状态
            appLiveData.loginStatusLiveData.postValue(false)
        }, {
            logoutLiveData.postValue(false)
        })
    }
}