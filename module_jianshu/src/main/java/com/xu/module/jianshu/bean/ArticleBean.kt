package com.xu.module.jianshu.bean

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ArticleBean(
    val children: List<Any>,
    val courseId: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val parentChapterId: Int,
    val userControlSetTop: Boolean,
    val visible: Int
)