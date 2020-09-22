package com.xu.module.wan.ui.fragment.knowledgesystem

import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.google.android.flexbox.FlexboxLayoutManager
import com.xu.commonlib.utlis.extention.go
import com.xu.commonlib.utlis.extention.singleDataItemClick
import com.xu.commonlib.utlis.extention.singleItemClick
import com.xu.module.wan.R
import com.xu.module.wan.bean.KnowledgeSystemBean
import com.xu.module.wan.constant.ARouterPath
import javax.inject.Inject

/**
 * 这里没有用databinding的方式，用了后，就卡成ppt了
 */
class KnowledgeSystemAdapter @Inject constructor() :
    BaseQuickAdapter<KnowledgeSystemBean, BaseViewHolder>(R.layout.w_item_knowledge_system) {
    override fun convert(holder: BaseViewHolder, item: KnowledgeSystemBean) {
        holder.setText(R.id.tv_name, item.name)
        holder.getView<RecyclerView>(R.id.rv_knowledge_item).run {
            setItemViewCacheSize(200)
            setHasFixedSize(true)
            adapter = SystemChildAdapter(item.children).apply {
                singleDataItemClick {
                    go(ARouterPath.web)
                }
            }
            layoutManager = FlexboxLayoutManager(context)
        }
    }
}