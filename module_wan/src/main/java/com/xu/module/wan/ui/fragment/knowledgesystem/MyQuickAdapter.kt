package com.xu.module.wan.ui.fragment.knowledgesystem

import com.chad.library.adapter.base.BaseSectionQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xu.module.wan.R
import com.xu.module.wan.bean.local.KnowledgeSystemLocalBean
import javax.inject.Inject

class MyQuickAdapter @Inject constructor() :
    BaseSectionQuickAdapter<KnowledgeSystemLocalBean, BaseViewHolder>(R.layout.w_item_knowledge_system_child) {
    init {
        setNormalLayout(R.layout.w_item_knowledge_system_header)
    }

    override fun convert(holder: BaseViewHolder, item: KnowledgeSystemLocalBean) {

    }

    override fun convertHeader(helper: BaseViewHolder, item: KnowledgeSystemLocalBean) {
    }
}