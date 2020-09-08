package com.xu.module.wan.bean

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.squareup.moshi.JsonClass
import com.xu.module.wan.ui.fragment.home.HomeArticleItemQuickAdapter

/**
 *文章item bean
 */
@JsonClass(generateAdapter = true)
data class ArticleItemBean(
    val apkLink: String,
    val audit: Int,
    val author: String,
    val canEdit: Boolean,
    val chapterId: Int,
    val chapterName: String,
    val collect: Boolean,
    val courseId: Int,
    val desc: String,
    val descMd: String,
    val envelopePic: String,
    val fresh: Boolean,
    val id: Int,
    val link: String,
    val niceDate: String,
    val niceShareDate: String,
    val origin: String,
    val prefix: String,
    val projectLink: String,
    val publishTime: Long,
    val realSuperChapterId: Int,
    val selfVisible: Int,
    val shareDate: Long?,
    val shareUser: String,
    val superChapterId: Int,
    val superChapterName: String,
    val tags: List<TagBean>,
    val title: String,
    val type: Int,
    val userId: Int,
    val visible: Int,
    val zan: Int
) : MultiItemEntity {
    override val itemType: Int
        //类型逻辑copy
        get() = if (envelopePic.isEmpty()) {
            HomeArticleItemQuickAdapter.TYPE_ARTICLE
        } else {
            HomeArticleItemQuickAdapter.TYPE_PROJECT
        }
}

@JsonClass(generateAdapter = true)
data class TagBean(
    val name: String,
    val url: String
)