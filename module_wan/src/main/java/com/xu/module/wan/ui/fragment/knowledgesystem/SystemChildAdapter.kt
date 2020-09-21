package com.xu.module.wan.ui.fragment.knowledgesystem

import android.graphics.Color
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.xu.module.wan.R
import com.xu.module.wan.bean.KnowledgeSystemBean
import com.xu.module.wan.databinding.WItemKnowledgeSystemChildBinding

class SystemChildAdapter(data: MutableList<KnowledgeSystemBean>) :
    BaseQuickAdapter<KnowledgeSystemBean, BaseDataBindingHolder<WItemKnowledgeSystemChildBinding>>(
        R.layout.w_item_knowledge_system_child, data
    ) {
    override fun convert(holder: BaseDataBindingHolder<WItemKnowledgeSystemChildBinding>, item: KnowledgeSystemBean) {
        holder.dataBinding?.item = item
    }

    companion object {

        @JvmStatic
        @BindingAdapter("randomColor")
        fun randomColor(tv: TextView, name: String) {
            val red = (0..190).random()
            val green = (0..190).random()
            val blue = (0..190).random()
            val color = Color.rgb(red, green, blue)
            tv.text = name
            tv.setTextColor(color)
        }
    }
}