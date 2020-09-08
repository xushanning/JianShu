package com.xu.module.wan.bean

import com.squareup.moshi.JsonClass

/**
 * 项目分类bean
 */
@JsonClass(generateAdapter = true)
data class ProjectBean(
    val children: List<String> = listOf(),
    val courseId: Int = 0,
    val id: Int = -1,
    val name: String = "",
    val order: Int = 0,
    val parentChapterId: Int = 0,
    val userControlSetTop: Boolean = false,
    val visible: Int = 0
)