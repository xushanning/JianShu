package com.xu.module.wan.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.utlis.extention.go
import com.xu.commonlib.utlis.extention.request
import com.xu.commonlib.utlis.extention.requestByNoResult
import com.xu.module.wan.api.WanService
import com.xu.module.wan.bean.local.CollectStateBean
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.utils.ext.createPager

/**
 * 文章收藏、取消收藏view model
 */
class ArticleCollectViewModel @ViewModelInject constructor(
    private val api: WanService,
    private val wanLiveData: WanLiveData
) : BaseViewModel() {

    /**
     * 收藏文章state
     */
    val collectStateLiveData by lazy {
        MutableLiveData<CollectStateBean>()
    }

    /**
     * 我收藏文章
     * 分页
     */
    val myCollectArticleLiveData by lazy {
        createPager {
            checkState()
            api.myCollectArticleList(it)
        }
    }

    /**
     * 检查登录状态
     */
    private fun checkState() {
        if (!wanLiveData.loginStateLiveData.value!!) {
            //未登录，跳转登录
            go(ARouterPath.login)
            return
        }
    }

    /**
     * 收藏站内文章
     * @param articleId 文章id
     * @param position list的位置，用于变更item的收藏状态
     */
    fun collectInnerArticle(articleId: Int, position: Int) {
        checkState()
        requestByNoResult({
            api.collectInnerStationArticle(articleId)
        }, {
            collectStateLiveData.value = CollectStateBean(true, position)
        }, {
            Logger.d(it)
        }, true)
    }

    /**
     * 收藏站外文章
     */
    fun collectOutArticle(title: String, author: String, link: String) {
        checkState()
        request({
            api.collectOutStationArticle(title, author, link)
        }, {

        }, {

        })
    }

    /**
     * 取消收藏文章列表页面里面的文章
     * @param articleId 文章id
     * @param position list的位置，用于变更item的收藏状态
     */
    fun unCollectArticleList(articleId: Int, position: Int) {
        checkState()
        requestByNoResult({
            api.unCollectArticleList(articleId)
        }, {
            collectStateLiveData.value = CollectStateBean(false, position)
        }, {

        }, true)
    }

    /**
     * 取消收藏我的收藏里面的文章
     */
    fun unCollectMyCollectArticle(articleId: Int, originId: Int) {
        checkState()
        request({
            api.unCollectMyCollectArticle(articleId, originId)
        }, {

        }, {

        })
    }


    /**
     * 获取收藏网站的列表
     */
    fun getMyCollectWebsiteList() {
        checkState()
        request({
            api.myCollectWebsiteList()
        }, {

        }, {

        })
    }

    /**
     * 收藏网站
     */
    fun collectWebsite(name: String, link: String) {
        checkState()
        request({
            api.collectWebsite(name, link)
        }, {

        }, {

        })
    }

    /**
     * 编辑收藏的网站
     */
    fun editCollectWebsite(id: String, name: String, link: String) {
        checkState()
        request({
            api.editCollectWebsite(id, name, link)
        }, {

        }, {

        })
    }

    /**
     * 删除收藏的网站
     */
    fun deleteCollectWebsite(id: String) {
        checkState()
        request({
            api.deleteCollectWebsite(id)
        }, {

        }, {

        })
    }
}