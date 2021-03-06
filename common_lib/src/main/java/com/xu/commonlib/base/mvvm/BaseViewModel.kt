package com.xu.commonlib.base.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author 许 on 2020/8/29.
 */
abstract class BaseViewModel : ViewModel() {


    /**
     * 展示dialog的LiveData
     */
    val showDialog = MutableLiveData<String>()

    /**
     *隐藏dialog
     *
     */
    val dismissDialog = MutableLiveData<Boolean>()

    /**
     * 夜间模式
     */
    val nightMode = AppLiveData.INSTANCE.nightModeLiveData

    /**
     * 透明度
     */
    val nightAlpha = AppLiveData.INSTANCE.nightAlphaLiveData


}