package com.xu.module.wan.ui.activity.login

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.map
import androidx.lifecycle.switchMap
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.livedata.BooleanLiveData
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
     * 登陆结果
     */
    val loginResult = BooleanLiveData()

    /**
     * 是否可点击
     */
    val loginEnable: MediatorLiveData<Boolean> =
        CombineLiveData(userName, password) { userName, password ->
            userName.isNotEmpty() && password.isNotEmpty()
        }

    /**
     *执行登陆
     */
    fun doLogin() {
        request({ api.login(userName.value, password.value) }, {
            //todo 入库
            loginResult.postValue(true)
        }, {
            context.showToast(it.errorMsg)
        })
    }
}