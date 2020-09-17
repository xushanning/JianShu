package com.xu.module.wan.ui.fragment.home

import androidx.paging.PagingSource
import com.xu.module.wan.api.WanService
import com.xu.module.wan.bean.ArticleItemBean
import javax.inject.Inject

/**
 * 文章列表的source
 * 这里太坑了~！！！！！
 * 用了dagger，导致一直是一个实例，然而刷新是需要一个新的实例的，就导致报错
 */
class ArticleSource constructor(private val api: WanService) :
    PagingSource<Int, ArticleItemBean>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticleItemBean> {
        //如果是null，那么就是第0页数据
        val page = params.key ?: 0

        return try {
            val res = api.getHomeArticleList(page)
            LoadResult.Page(
                data = res.data?.datas!!,
                //如果需要上拉加载，那么就设置该参数，否则，不设置
                //prevKey =if (page <= 1) null else page - 1
                prevKey = null,
                //如果空的说明没有更多了
                nextKey = if (res.data?.datas!!.size == 0) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }
}