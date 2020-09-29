package com.xu.module.wan.ui.activity.setting

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.utlis.extention.requestByNoResult
import com.xu.module.wan.api.WanService
import com.xu.module.wan.db.WanSp
import com.xu.module.wan.viewmodel.WanLiveData

class SettingViewModel @ViewModelInject constructor(
    private val api: WanService,
    private val wanLiveData: WanLiveData,
    private val cookieJar: PersistentCookieJar
) : BaseViewModel() {

    val loginStatus = wanLiveData.loginStateLiveData

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
            wanLiveData.loginStateLiveData.postValue(false)
            WanSp.currentUserId = -1
            WanSp.loginState = false
            //清除cookie
            cookieJar.clear()
        }, {
            logoutLiveData.postValue(false)
        })
    }
}