package com.xu.module.wan.ui.fragment.wepublicarticle

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.utlis.extention.request
import com.xu.module.wan.api.WanService
import com.xu.module.wan.bean.ArticleItemBean

class WePublicArticleViewModel @ViewModelInject constructor(
    private val api: WanService
) : BaseViewModel() {
    val historyArticleLiveData = MutableLiveData<MutableList<ArticleItemBean>>()
    fun getHistoryArticleList(id: Int) {
        request({
            api.getPublicAccountHistoryById(0, id)
        }, {
            historyArticleLiveData.postValue(it.datas)
        }, {

        })
    }
}