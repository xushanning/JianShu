package com.xu.module.wan.ui.activity.search

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.xu.module.wan.R
import com.xu.module.wan.bean.HotKeyBean
import com.xu.module.wan.databinding.WItemHotKeyHistoryBinding
import javax.inject.Inject

/**
 * @author 许 on 2020/9/20.
 */
class SearchHotKeyAdapter @Inject constructor() :
    BaseQuickAdapter<HotKeyBean, BaseDataBindingHolder<WItemHotKeyHistoryBinding>>(R.layout.w_item_hot_key_history) {


    override fun convert(holder: BaseDataBindingHolder<WItemHotKeyHistoryBinding>, item: HotKeyBean) {
        val binding = holder.dataBinding
        binding?.item = item
    }
}