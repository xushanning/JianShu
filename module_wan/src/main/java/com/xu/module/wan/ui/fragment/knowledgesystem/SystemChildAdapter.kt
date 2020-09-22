package com.xu.module.wan.ui.fragment.knowledgesystem

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xu.commonlib.utlis.ColorUtil
import com.xu.module.wan.R
import com.xu.module.wan.bean.KnowledgeSystemBean

class SystemChildAdapter(data: MutableList<KnowledgeSystemBean>) :
    BaseQuickAdapter<KnowledgeSystemBean, BaseViewHolder>(
        R.layout.w_item_knowledge_system_child, data
    ) {
    override fun convert(holder: BaseViewHolder, item: KnowledgeSystemBean) {
        holder.setText(R.id.tv_name, item.name)
            .setTextColor(R.id.tv_name, ColorUtil.getRandomColor())
    }
}