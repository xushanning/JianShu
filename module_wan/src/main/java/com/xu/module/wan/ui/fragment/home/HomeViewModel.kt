package com.xu.module.wan.ui.fragment.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.utlis.extention.request
import com.xu.commonlib.utlis.extention.requestByNoResult
import com.xu.module.wan.api.WanService
import com.xu.module.wan.bean.ArticleItemBean
import com.xu.module.wan.bean.BannerBean
import com.xu.module.wan.bean.base.BasePageResBean
import com.xu.module.wan.bean.base.BaseResBean
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class HomeViewModel @ViewModelInject constructor(
    private val api: WanService

) : BaseViewModel() {
    /**
     * 首页文章
     */
    val homeArticleData = MutableLiveData<MutableList<ArticleItemBean>>()

    /**
     * banner数据
     */
    val bannerLiveData = MutableLiveData<MutableList<BannerBean>>()

    val pager by lazy {
        Pager(config = PagingConfig(20, 1),
            pagingSourceFactory = { ArticleSource(api) }).flow.cachedIn(viewModelScope)
    }


    fun getHomeData(isRefresh: Boolean = false) {
        request({
            getCombineArticleList()
        }, {
            homeArticleData.postValue(it.datas)
        }, {
            Logger.d(it.message)
        })
    }

    private suspend fun getCombineArticleList(): BaseResBean<BasePageResBean<MutableList<ArticleItemBean>>> {
        return withContext(Dispatchers.IO) {
            val articleList = async { api.getHomeArticleList(0) }
            val topArticleList = async { api.getHomeTopArticleList() }
            articleList.await().data?.datas?.addAll(0, topArticleList.await().data!!)
            articleList.await()
        }
    }

    /**
     * 获取banner数据
     */
    fun getBannerData() {
        request({ api.getBannerData() },
            bannerLiveData, {

            })
    }
}