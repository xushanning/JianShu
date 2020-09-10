package com.xu.module.wan.ui.fragment.wepublic

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.utlis.extention.request
import com.xu.module.wan.api.WanService
import com.xu.module.wan.bean.PublicAccountBean

class WePublicViewModel @ViewModelInject constructor(
    private val api: WanService
) : BaseViewModel() {
    val wePublicAccountLiveData = MutableLiveData<MutableList<PublicAccountBean>>()

    fun getWePublicAccountList() {
        request({
            api.getPublicAccountList()
        }, wePublicAccountLiveData, {
            Logger.d(it)
        })
    }
}