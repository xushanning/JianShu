package com.xu.module.wan.ui.fragment.wepublicarticle

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.utlis.extention.request
import com.xu.module.wan.api.WanService
import com.xu.module.wan.bean.ArticleItemBean
import com.xu.module.wan.utils.ext.createPager

class WePublicArticleViewModel @ViewModelInject constructor(
    private val api: WanService
) : BaseViewModel() {

    fun getHistoryArticleList(id: Int) =createPager {
        api.getPublicAccountHistoryById(it, id)
    }


}