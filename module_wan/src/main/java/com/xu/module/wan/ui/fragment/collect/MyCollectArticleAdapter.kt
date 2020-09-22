package com.xu.module.wan.ui.fragment.collect

import com.xu.module.wan.R
import com.xu.module.wan.base.BasePagingAdapter
import com.xu.module.wan.base.BaseViewHolder
import com.xu.module.wan.bean.MyCollectBean
import javax.inject.Inject

class MyCollectArticleAdapter @Inject constructor() :
    BasePagingAdapter<MyCollectBean, BaseViewHolder>(
        R.layout.w_item_my_collect_article,
        { oldItem, newItem ->
            oldItem.id == newItem.id
        },
        { oldItem, newItem ->
            oldItem.id == newItem.id
        }) {



    override fun convert(holder: BaseViewHolder, item: MyCollectBean) {

    }

}