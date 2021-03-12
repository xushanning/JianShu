package com.xu.module.jianshu.ui.coordinatorlayout

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

import com.xu.module.jianshu.R

class CoordinatorAdapter(data: List<String>) : BaseQuickAdapter<String, BaseViewHolder>(R.layout.j_item_coordinator, data) {
    override fun convert(helper: BaseViewHolder?, item: String?) {
        helper?.setText(R.id.tv_item, item)
    }
}