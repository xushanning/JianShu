package com.xu.module.wan.ui.login

import androidx.databinding.ObservableField
import androidx.hilt.lifecycle.ViewModelInject
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.utlis.extention.request
import com.xu.module.wan.api.WanService

class LoginViewModel @ViewModelInject constructor(
    private val api: WanService
) : BaseViewModel() {
    var name = ObservableField("原始的name")


    fun getListData() {
        request({
            api.getArticleList()
        }, {
            var result = ""
            it.forEach { item ->
                result += item.name
            }
            name.set(result)
        }, {

        })
    }
}