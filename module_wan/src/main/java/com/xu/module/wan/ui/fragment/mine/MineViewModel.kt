package com.xu.module.wan.ui.fragment.mine

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.module.wan.db.AppLiveData
import com.xu.module.wan.db.AppSp
import com.xu.module.wan.db.dao.IUserDao
import com.xu.module.wan.db.entity.UserEntity
import kotlinx.coroutines.launch

class MineViewModel @ViewModelInject constructor(
    private val userDao: IUserDao
) : BaseViewModel() {
    val loginStatus = AppLiveData.loginStatusLiveData

    val userInfoLiveData = MutableLiveData<UserEntity>().map {
        it.userInfoBean
    } as MutableLiveData


    fun changeUi() {
        viewModelScope.launch {
            userInfoLiveData.postValue(userDao.queryUserInfo(AppSp.currentUserId)?.userInfoBean)
        }
    }

}