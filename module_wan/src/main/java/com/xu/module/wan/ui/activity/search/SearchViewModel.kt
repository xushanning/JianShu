package com.xu.module.wan.ui.activity.search

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.paging.PagingData
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.livedata.BooleanLiveData
import com.xu.commonlib.livedata.StringLiveData
import com.xu.commonlib.utlis.extention.request
import com.xu.module.wan.api.WanService
import com.xu.module.wan.bean.ArticleItemBean
import com.xu.module.wan.bean.HotKeyBean
import com.xu.module.wan.utils.ext.createPager

class SearchViewModel @ViewModelInject constructor(
    private val api: WanService,
) : BaseViewModel() {


    /**
     *默认搜索
     */
    val searchHintLiveData = StringLiveData()

    /**
     * 显示
     * true:显示热词和搜索历史
     * false:显示搜索历史
     */
    val uiLiveData = BooleanLiveData(true)

    /**
     * 搜索内容
     */
    val searchLiveData = StringLiveData()

    /**
     * 搜索分页
     */
    var pager = createPager {
        val content = if (searchLiveData.value.isEmpty()) {
            //如果没有输入，那么搜索默认的hilt
            searchHintLiveData.value!!
        } else {
            searchLiveData.value
        }
        api.doSearch(it, content)
    }


}