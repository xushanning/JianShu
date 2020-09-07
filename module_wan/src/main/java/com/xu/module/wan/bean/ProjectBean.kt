package com.xu.module.wan.bean

import com.squareup.moshi.JsonClass

/**
 * 项目分类bean
 */
@JsonClass(generateAdapter = true)
data class ProjectBean(
    val children: List<Any>,
    val courseId: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val parentChapterId: Int,
    val userControlSetTop: Boolean,
    val visible: Int
)