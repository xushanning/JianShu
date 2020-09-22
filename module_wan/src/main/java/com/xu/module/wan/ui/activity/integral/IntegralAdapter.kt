package com.xu.module.wan.ui.activity.integral

import com.xu.module.wan.R
import com.xu.module.wan.base.BaseDataBindingHolder
import com.xu.module.wan.base.BasePagingAdapter
import com.xu.module.wan.bean.RankItemBean
import com.xu.module.wan.databinding.WItemIntegralBinding
import javax.inject.Inject

class IntegralAdapter @Inject constructor() :
    BasePagingAdapter<RankItemBean, BaseDataBindingHolder<WItemIntegralBinding>>(R.layout.w_item_integral,
        { oldItem, newItem ->
            oldItem.rank == newItem.rank
        },
        { oldItem, newItem ->
            oldItem.rank == newItem.rank
        }) {


    override fun convert(holder: BaseDataBindingHolder<WItemIntegralBinding>, item: RankItemBean) {
        holder.dataBinding?.item = item
    }
}