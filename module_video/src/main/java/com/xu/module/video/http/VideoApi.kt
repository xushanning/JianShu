package com.xu.module.video.http

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * @author 言吾許
 */
interface VideoApi {
    companion object {
        /**
         * base url
         */
        const val BASE_URL = "http://39.98.198.118:7000/yunli/app/v1/"
    }


    /**
     * 获取分享页面的html代码
     *
     * @param shareUrl 分享地址
     * @return observable
     */
    @GET
    fun getVideoHtml(@Url shareUrl: String): Observable<String>
}