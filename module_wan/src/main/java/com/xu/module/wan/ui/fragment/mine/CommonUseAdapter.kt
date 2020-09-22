package com.xu.module.wan.ui.fragment.mine

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.xu.module.wan.R
import com.xu.module.wan.bean.CommonUseBean
import com.xu.module.wan.databinding.WItemCommonUseBinding
import javax.inject.Inject

/**
 * 常用功能
 */
class CommonUseAdapter @Inject constructor() :
    BaseQuickAdapter<CommonUseBean, BaseDataBindingHolder<WItemCommonUseBinding>>(R.layout.w_item_common_use) {
    override fun convert(holder: BaseDataBindingHolder<WItemCommonUseBinding>, item: CommonUseBean) {
          holder.dataBinding?.item = item
    }

    companion object {

    }
}