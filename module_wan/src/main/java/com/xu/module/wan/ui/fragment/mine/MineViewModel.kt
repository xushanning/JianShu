package com.xu.module.wan.ui.fragment.mine

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.utlis.extention.request
import com.xu.module.wan.api.WanService
import com.xu.module.wan.bean.RankBean
import com.xu.module.wan.db.WanSp
import com.xu.module.wan.db.dao.IUserDao
import com.xu.module.wan.db.entity.UserEntity
import com.xu.module.wan.viewmodel.WanLiveData
import kotlinx.coroutines.launch

class MineViewModel @ViewModelInject constructor(
    private val api: WanService,
    private val userDao: IUserDao,
    appLiveData: WanLiveData
) : BaseViewModel() {

    val loginStatus = appLiveData.loginStateLiveData

    val userInfoLiveData = MutableLiveData<UserEntity>().map {
        it.userInfoBean
    } as MutableLiveData

    /**
     * 排名+积分
     */
    val rankLiveData = MutableLiveData<RankBean>()


    fun changeUi() {
        viewModelScope.launch {
            userInfoLiveData.postValue(userDao.queryUserInfo(WanSp.currentUserId)?.userInfoBean)
        }
    }

    /**
     * 获取排名和积分
     */
    fun getRank() {
        request({
            api.getRank()
        }, rankLiveData, {

        })
    }

}