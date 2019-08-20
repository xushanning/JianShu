package com.xu.module.jianshu.ui.retrofit

import okhttp3.Call


/**
 * @author 言吾許
 */
interface ServiceApi {
    /**
     * 获取公众号列表
     * 基于 玩android开放api
     */
    @GET("/wxarticle/chapters/json")
    fun getPublicList():Call
}