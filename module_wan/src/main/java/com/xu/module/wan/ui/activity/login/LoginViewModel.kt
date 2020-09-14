package com.xu.module.wan.ui.activity.login

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.livedata.BooleanLiveData
import com.xu.commonlib.livedata.StringLiveData
import com.xu.commonlib.utlis.extention.request
import com.xu.commonlib.utlis.extention.showToast
import com.xu.module.wan.api.WanService
import com.xu.module.wan.db.AppLiveData
import com.xu.module.wan.db.AppSp
import com.xu.module.wan.db.dao.IUserDao
import com.xu.module.wan.db.entity.UserEntity
import kotlinx.coroutines.launch

class LoginViewModel @ViewModelInject constructor(
    private val api: WanService,
    private val context: Context,
    private val userDao: IUserDao
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
            viewModelScope.launch {
                AppSp.currentUserId = it.id
                AppLiveData.loginStatus = true

                val current = userDao.queryUserInfo(it.id)
                if (current == null) {
                    userDao.saveUserInfo(UserEntity(it.id, it))
                } else {
                    userDao.updateUserInfo(UserEntity(it.id, it))
                }
                loginResult.postValue(true)
            }
        }, {
            context.showToast(it.errorMsg)
        })
    }
}