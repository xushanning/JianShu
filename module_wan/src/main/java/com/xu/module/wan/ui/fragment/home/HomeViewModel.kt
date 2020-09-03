package com.xu.module.wan.ui.fragment.home

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.utlis.extention.request
import com.xu.module.wan.api.WanService
import com.xu.module.wan.bean.ArticleItemBean
import com.xu.module.wan.bean.base.BasePageResBean
import com.xu.module.wan.bean.base.BaseResBean
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class HomeViewModel @ViewModelInject constructor(
    private val api: WanService, private val context: Context
) : BaseViewModel() {
    val homeArticleData: MutableLiveData<MutableList<ArticleItemBean>> = MutableLiveData()


    fun getHomeData() {
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
}