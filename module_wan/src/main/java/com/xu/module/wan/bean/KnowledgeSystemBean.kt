package com.xu.module.wan.bean

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.squareup.moshi.JsonClass
import com.xu.module.wan.ui.fragment.knowledgesystem.KnowledgeSystemAdapter

@JsonClass(generateAdapter = true)
data class KnowledgeSystemBean(
    val children: MutableList<KnowledgeSystemBean>,
    val courseId: Int,
    // id会在查看该目录下所有文章时有用
    val id: Int,
    // 一级的名称
    val name: String,
    val order: Int,
    //如果为0，那么说明为第一层
    val parentChapterId: Int,
    val visible: Int
) : MultiItemEntity {
    override val itemType: Int
        get() = if (parentChapterId == 0) {
            KnowledgeSystemAdapter.TYPE_TITLE
        } else {
            KnowledgeSystemAdapter.TYPE_CONTENT
        }
}