package com.xu.module.jianshu.api

import com.xu.module.jianshu.bean.ArticleBean
import com.xu.module.jianshu.bean.BaseResBean
import retrofit2.http.GET

/**
 *
 */
interface WanService {

    @GET("wxarticle/chapters/json")
    suspend fun getArticleList(): BaseResBean<List<ArticleBean>>
}