package com.xu.module.wan.ui.fragment.knowledgesystem

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.google.android.flexbox.FlexboxLayoutManager
import com.orhanobut.logger.Logger
import com.xu.module.wan.R
import com.xu.module.wan.bean.KnowledgeSystemBean
import com.xu.module.wan.databinding.WItemKnowledgeSystemBinding
import javax.inject.Inject

class KnowledgeSystemAdapter @Inject constructor() :
    BaseQuickAdapter<KnowledgeSystemBean, BaseDataBindingHolder<WItemKnowledgeSystemBinding>>(R.layout.w_item_knowledge_system) {
    override fun convert(holder: BaseDataBindingHolder<WItemKnowledgeSystemBinding>, item: KnowledgeSystemBean) {
        holder.dataBinding?.item = item
    }

    companion object {

        @JvmStatic
        @BindingAdapter("childData")
        fun setChildData(rv: RecyclerView, childData: MutableList<KnowledgeSystemBean>) {

            rv.run {
                setHasFixedSize(true)
                isNestedScrollingEnabled = false
                setItemViewCacheSize(200)
                adapter = SystemChildAdapter(childData)
                layoutManager = FlexboxLayoutManager(context)
            }

        }
    }
}