package com.xu.module.wan.bean

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.squareup.moshi.JsonClass

/**
 * @author 许 on 2020/9/21.
 */
@JsonClass(generateAdapter = true)
data class NavigationBean(
    val articles: MutableList<ArticleBean>,
    val cid: Int,
    val name: String
)

@JsonClass(generateAdapter = true)
data class ArticleBean(
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
//    val shareDate: Any,
    val shareUser: String,
    val superChapterId: Int,
    val superChapterName: String,
    val tags: List<Any>,
    val title: String,
    val type: Int,
    val userId: Int,
    val visible: Int,
    val zan: Int
)