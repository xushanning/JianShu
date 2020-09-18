package com.xu.module.wan.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.utlis.extention.request
import com.xu.module.wan.api.WanService

/**
 * 文章收藏、取消收藏view model
 */
class ArticleCollectViewModel @ViewModelInject constructor(
    private val api: WanService
) : BaseViewModel() {


    /**
     * 收藏站内文章
     */
    fun collectInnerArticle(articleId: Int) {
        request({
            api.collectInnerStationArticle(articleId)
        }, {

        }, {

        })
    }

    /**
     * 收藏站外文章
     */
    fun collectOutArticle(title: String, author: String, link: String) {
        request({
            api.collectOutStationArticle(title, author, link)
        }, {

        }, {

        })
    }

    /**
     * 取消收藏文章列表页面里面的文章
     */
    fun unCollectArticleList(articleId: Int) {
        request({
            api.unCollectArticleList(articleId)
        }, {

        }, {

        })
    }

    /**
     * 取消收藏我的收藏里面的文章
     */
    fun unCollectMyCollectArticle(articleId: Int, originId: Int) {
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
        request({
            api.deleteCollectWebsite(id)
        }, {

        }, {

        })
    }
}