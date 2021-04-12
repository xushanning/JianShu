package com.xu.module.video.ui.fragment.completed

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xu.module.video.R

/**
 * 已完成的adapter
 */
class CompleteQuickAdapter(data: MutableList<String>) :
    BaseQuickAdapter<String, BaseViewHolder>(R.layout.v_item_complete, data) {


    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.tv_item, item)
    }
}