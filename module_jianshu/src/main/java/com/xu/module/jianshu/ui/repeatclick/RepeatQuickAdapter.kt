package com.xu.module.jianshu.ui.repeatclick

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.xu.module.jianshu.R

/**
 * @author 言吾許
 */
class RepeatQuickAdapter(data: List<String>) :
    BaseQuickAdapter<String, BaseViewHolder>(R.layout.j_item_repeat_click, data) {
    override fun convert(helper: BaseViewHolder, item: String) {
        helper.setText(R.id.tv_position, item)
            .addOnClickListener(R.id.bt_child)
    }
}