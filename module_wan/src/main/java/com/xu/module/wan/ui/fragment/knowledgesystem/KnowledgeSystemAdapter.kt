package com.xu.module.wan.ui.fragment.knowledgesystem

import androidx.databinding.DataBindingUtil
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xu.module.wan.R
import com.xu.module.wan.bean.KnowledgeSystemBean
import com.xu.module.wan.databinding.WItemKnowledgeContentBinding
import com.xu.module.wan.databinding.WItemKnowledgeTitleBinding
import javax.inject.Inject

class KnowledgeSystemAdapter @Inject constructor() :
    BaseMultiItemQuickAdapter<KnowledgeSystemBean, BaseViewHolder>() {

    companion object {
        const val TYPE_TITLE = 1
        const val TYPE_CONTENT = 2
    }

    init {
        addItemType(TYPE_TITLE, R.layout.w_item_knowledge_title)
        addItemType(TYPE_CONTENT, R.layout.w_item_knowledge_content)
    }

    override fun convert(holder: BaseViewHolder, item: KnowledgeSystemBean) {
        when (item.itemType) {
            TYPE_TITLE -> {
                val binding = DataBindingUtil.bind<WItemKnowledgeTitleBinding>(holder.itemView)
                binding?.item = item
            }
            TYPE_CONTENT -> {
                val binding = DataBindingUtil.bind<WItemKnowledgeContentBinding>(holder.itemView)
                binding?.item = item
            }
        }
    }
}