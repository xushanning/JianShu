package com.xu.commonlib.base.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author 许 on 2020/8/29.
 */
abstract class BaseViewModel : ViewModel() {


    /**
     * 展示dialog的LiveData
     * 调用AppLiveData单例是因为如果通过by viewModels()方法引入ViewModel的话，就无法控制loading
     */
    val showDialog: MutableLiveData<String> by lazy { AppLiveData.INSTANCE.showDialog }

    /**
     *隐藏dialog
     *
     */
    val dismissDialog: MutableLiveData<Boolean> by lazy { AppLiveData.INSTANCE.dismissDialog }
}