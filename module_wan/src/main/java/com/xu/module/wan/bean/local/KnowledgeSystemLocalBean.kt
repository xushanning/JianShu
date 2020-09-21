package com.xu.module.wan.bean.local

import com.chad.library.adapter.base.entity.SectionEntity
import com.xu.module.wan.bean.KnowledgeSystemBean

class KnowledgeSystemLocalBean constructor(private val bean: KnowledgeSystemBean) : SectionEntity {
    override val isHeader: Boolean
        get() = bean.children.size != 0
}