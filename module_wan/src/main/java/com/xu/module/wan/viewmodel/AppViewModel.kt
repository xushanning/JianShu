package com.xu.module.wan.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.map
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.module.wan.db.dao.IUserDao

/**
 * 全局的ViewModel
 */
class AppViewModel @ViewModelInject constructor(
    private val userDao: IUserDao,
) : BaseViewModel() {
    val userInfoLiveData = userDao.queryUserInfo().map {

    }
}