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
     * 登录
     */
    @FormUrlEncoded
    @POST("user/login")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): BaseResBean<UserInfoBean>

    /**
     * 注册
     * @param username 用户名
     * @param password 密码
     * @param rePassword 重复密码
     */
    @POST("user/register")
    suspend fun register(@Field("username") username: String,
                         @Field("password") password: String,
                         @Field("repassword") rePassword: String
    ): BaseResBean<Any>

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
     */
    @GET("user/logout/json")
    suspend fun logout(): BaseResBean<Any>


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

    /**
     * 查看用户的积分和排名
     */
    @GET("lg/coin/userinfo/json")
    suspend fun getRank(): BaseResBean<RankBean>

    /**
     * 收藏站内文章
     */
    @POST("lg/collect/{articleId}/json")
    suspend fun collectInnerStationArticle(
        @Path("articleId") articleId: Int
    ): BaseResBean<Any>

    /**
     * 收藏站外文章
     */
    @POST("lg/collect/add/json")
    suspend fun collectOutStationArticle(
        @Field("title") title: String,
        @Field("author") author: String,
        @Field("link") link: String
    ): BaseResBean<Any>

    /**
     * 取消收藏
     * 位置：文章列表用这个
     */
    @POST("lg/uncollect_originId/{articleId}/json")
    suspend fun unCollectArticleList(@Path("articleId") articleId: Int): BaseResBean<Any>

    /**
     * 取消收藏
     * 位置：我的收藏页面
     *originId没有则传-1
     */
    @POST("lg/uncollect/{articleId}/json")
    suspend fun unCollectMyCollectArticle(
        @Path("articleId") articleId: Int,
        @Field("originId") originId: Int
    ): BaseResBean<Any>

    /**
     * 收藏网站列表
     *
     */
    @GET("lg/collect/usertools/json")
    suspend fun myCollectWebsiteList(): BaseResBean<MutableList<Any>>

    /**
     * 收藏网站
     *
     */
    @POST("lg/collect/addtool/json")
    suspend fun collectWebsite(
        @Field("name") name: String,
        @Field("link") link: String
    ): BaseResBean<Any>

    /**
     * 编辑收藏的网站
     */
    @POST("lg/collect/updatetool/json")
    suspend fun editCollectWebsite(
        @Field("id") id: String,
        @Field("name") name: String,
        @Field("link") link: String
    ): BaseResBean<Any>

    /**
     * 删除收藏的网站
     */
    @POST("lg/collect/deletetool/json")
    suspend fun deleteCollectWebsite(@Field("id") id: String): BaseResBean<Any>

    /**
     * 获取搜索热词
     */
    @GET("hotkey/json")
    suspend fun getHotKey(): BaseResBean<MutableList<HotKeyBean>>

    /**
     * 进行搜索
     */
    @POST("article/query/{page}/json")
    suspend fun doSearch(
        @Path("page") page: Int,
        @Query("k") content: String
    ): BaseResBean<BasePageResBean<MutableList<ArticleItemBean>>>

    /**
     * 获取体系数据
     */
    @GET("tree/json")
    suspend fun getKnowledgeSystemData(): BaseResBean<MutableList<KnowledgeSystemBean>>

    /**
     * 获取导航列表数据
     */
    @GET("navi/json")
    suspend fun getNavigationData(): BaseResBean<MutableList<NavigationBean>>
}