package com.xu.module.wan.bean

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class KnowledgeSystemBean(
    val children: MutableList<KnowledgeSystemBean>,
    val courseId: Int,
    // id会在查看该目录下所有文章时有用
    val id: Int,
    // 一级的名称
    val name: String,
    val order: Int,
    val parentChapterId: Int,
    val visible: Int
)