package com.xu.module.wan.ui.fragment.home

import androidx.paging.PagingSource
import com.xu.module.wan.api.WanService
import com.xu.module.wan.bean.ArticleItemBean
import javax.inject.Inject

class ArticleSource @Inject constructor(private val api: WanService) : PagingSource<Int, ArticleItemBean>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticleItemBean> {
        //如果是null，那么就是第0页数据
        val page = params.key ?: 0

        return try {
            val res = api.getHomeArticleList(11)
            LoadResult.Page(
                res.data?.datas!!,
                if (page == 0) null else page - 1,
                page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }
}