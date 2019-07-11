package com.xu.module.sport.ui.activity.history

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.xu.module.sport.R

/**
 * @author 言吾許
 * 吸附 adapter
 */
class HistoryListAdapter(data: List<HistoryBean>) :
    BaseMultiItemQuickAdapter<HistoryBean, BaseViewHolder>(data) {
    companion object {
        const val TYPE_HEADER = 1
        const val TYPE_DATA = 2
    }

    init {
        addItemType(TYPE_HEADER, R.layout.s_item_header)
        addItemType(TYPE_DATA, R.layout.s_item_data)
    }

    override fun convert(helper: BaseViewHolder?, item: HistoryBean) {

    }


}