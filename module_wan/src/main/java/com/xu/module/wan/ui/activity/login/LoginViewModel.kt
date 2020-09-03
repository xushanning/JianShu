package com.xu.module.wan.ui.activity.login

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.livedata.StringLiveData
import com.xu.commonlib.utlis.extention.request
import com.xu.commonlib.utlis.extention.showToast
import com.xu.module.wan.api.WanService

class LoginViewModel @ViewModelInject constructor(
    private val api: WanService, private val context: Context
) : BaseViewModel() {


    /**
     * 用户名
     */
    val userName = StringLiveData()

    /**
     * 密码
     */
    val password = StringLiveData()

    /**
     *执行登陆
     */
    fun doLogin() {
        request({ api.login(userName.value, password.value) }, {
            Logger.d(it.username)
        }, {
            context.showToast(it.errorMsg)
        })
    }
}