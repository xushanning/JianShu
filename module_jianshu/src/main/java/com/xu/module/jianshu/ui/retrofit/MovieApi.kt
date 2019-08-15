package com.xu.module.jianshu.ui.retrofit

import okhttp3.Call


/**
 * @author 言吾許
 */
interface MovieApi {
    /**
     *  获取指定id的电影详情
     */
    @GET("/hello/get")
    fun getMovieDetail(movieId: String): Call

    /**
     * 获取某年的电影列表
     */
    @POST("/hello/post")
    fun getMovieList(year: String): Call
}