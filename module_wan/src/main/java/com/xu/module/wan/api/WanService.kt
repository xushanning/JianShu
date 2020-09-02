package com.xu.module.wan.api


import com.xu.module.wan.bean.*
import retrofit2.http.*

/**
 *玩android api
 */
interface WanService {

    /**
     * 登陆
     */
    @FormUrlEncoded
    @POST("user/login")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): BaseResBean<UserInfoBean>

    /**
     * 注册
     */
    @POST("user/register")
    suspend fun register(): BaseResBean<Any>

    /**
     * 登出
     * @param username 用户名
     * @param password 密码
     * @param rePassword 重复密码
     */
    @POST("user/register")
    suspend fun logout(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("repassword") rePassword: String
    ): BaseResBean<String>

    /**
     *获取公众号列表
     */
    @GET("wxarticle/chapters/json")
    suspend fun getPublicAccountList(): BaseResBean<MutableList<PublicAccountBean>>

    /**
     *查看某个公众号历史数据
     *@param page 公众号页码
     * @param accountId 公众号id
     */
    @GET("wxarticle/list/{accountId}/{page}/json")
    suspend fun getPublicAccountHistoryById(
        @Path("page") page: Int,
        @Path("accountId") accountId: String
    ): BaseResBean<BasePageResBean<MutableList<PublicAccountHistoryBean>>>


}