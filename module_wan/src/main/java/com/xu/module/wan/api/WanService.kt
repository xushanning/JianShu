package com.xu.module.wan.api


import com.xu.module.wan.bean.*
import com.xu.module.wan.bean.base.BasePageResBean
import com.xu.module.wan.bean.base.BaseResBean
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
     * 获取首页置顶的文章列表
     */
    @GET("article/top/json")
    suspend fun getHomeTopArticleList(): BaseResBean<MutableList<ArticleItemBean>>

    /**
     * 获取首页banner数据
     */
    @GET("banner/json")
    suspend fun getBannerData(): BaseResBean<MutableList<BannerBean>>

    /**
     * 获取首页的文章列表数据
     */
    @GET("article/list/{page}/json")
    suspend fun getHomeArticleList(@Path("page") page: Int): BaseResBean<BasePageResBean<MutableList<ArticleItemBean>>>

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
     * 获取项目分类
     */
    @GET("project/tree/json")
    suspend fun getProjectType(): BaseResBean<MutableList<ProjectBean>>

    /**
     * 获取最新的文章列表
     */
    @GET("article/listproject/{page}/json")
    suspend fun getLatestProjectList(@Path("page") page: Int): BaseResBean<BasePageResBean<MutableList<ArticleItemBean>>>

    /**
     * 获取某一类下的文章列表
     */
    @GET("project/list/{page}/json")
    suspend fun getProjectListByType(
        @Path("page") page: Int,
        @Query("cid") id: Int
    ): BaseResBean<BasePageResBean<MutableList<ArticleItemBean>>>

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
        @Path("accountId") accountId: Int
    ): BaseResBean<BasePageResBean<MutableList<ArticleItemBean>>>


}