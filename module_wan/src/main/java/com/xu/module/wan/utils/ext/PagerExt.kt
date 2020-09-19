package com.xu.module.wan.utils.ext

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.xu.module.wan.base.BaseSource
import com.xu.module.wan.bean.base.BasePageResBean
import com.xu.module.wan.bean.base.BaseResBean

/**
 * @author 许 on 2020/9/20.
 * Pager 扩展
 */


fun <Value : Any> ViewModel.createPager(source: suspend (Int) -> BaseResBean<BasePageResBean<MutableList<Value>>>):
        LiveData<PagingData<Value>> {
    return Pager(
        config = PagingConfig(20, 20),
        pagingSourceFactory = { BaseSource(source) }
    ).flow.cachedIn(viewModelScope)
        .asLiveData()
}