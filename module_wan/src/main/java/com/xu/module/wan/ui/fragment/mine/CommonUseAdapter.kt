package com.xu.module.wan.ui.fragment.mine

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.xu.commonlib.base.BaseApplication
import com.xu.commonlib.utlis.extention.load
import com.xu.module.wan.R
import com.xu.module.wan.bean.CommonUseBean
import com.xu.module.wan.databinding.WItemCommonUseBinding

/**
 * 常用功能
 */
class CommonUseAdapter :
    BaseQuickAdapter<CommonUseBean, BaseDataBindingHolder<WItemCommonUseBinding>>(R.layout.w_item_common_use) {
    override fun convert(holder: BaseDataBindingHolder<WItemCommonUseBinding>, item: CommonUseBean) {
        val binding = holder.dataBinding
        binding?.item = item
        binding?.executePendingBindings()
    }

    companion object {
        @JvmStatic
        @BindingAdapter("imgResId")
        fun loadImage(img: ImageView, resId: String) {
            val id = img.context.resources.getIdentifier(resId, "drawable", img.context.packageName)
            img.setImageResource(id)
        }
    }
}