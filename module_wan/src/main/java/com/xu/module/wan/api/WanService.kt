package com.xu.module.wan.api


import com.xu.module.wan.bean.ArticleBean
import com.xu.module.wan.bean.BaseResBean
import retrofit2.http.GET

/**
 *
 */
interface WanService {

    @GET("wxarticle/chapters/json")
    suspend fun getArticleList(): BaseResBean<List<ArticleBean>>
}