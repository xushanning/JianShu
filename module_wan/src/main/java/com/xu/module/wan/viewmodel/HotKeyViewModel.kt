package com.xu.module.wan.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.utlis.extention.request
import com.xu.module.wan.api.WanService
import com.xu.module.wan.bean.HotKeyBean

/**
 * @author 许 on 2020/9/20.
 * 热词model
 */
class HotKeyViewModel @ViewModelInject constructor(
    private val api: WanService,
) : BaseViewModel() {
    /**
     * 热词list
     */
    val hotKeyLiveData = MutableLiveData<MutableList<HotKeyBean>>()

    /**
     * 获取热词
     */
    fun getHotKey() {
        request({
            api.getHotKey()
        }, hotKeyLiveData, {
            Logger.d(it.message)
        })
    }
}