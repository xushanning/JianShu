package com.xu.module.wan.ui.fragment.home

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.xu.module.wan.R
import com.xu.module.wan.bean.ArticleItemBean
import com.xu.module.wan.databinding.WItemArticleBinding

class HomeArticleItemQuickAdapter :
    BaseQuickAdapter<ArticleItemBean, BaseDataBindingHolder<WItemArticleBinding>>(R.layout.w_item_article) {

    override fun convert(
        holder: BaseDataBindingHolder<WItemArticleBinding>,
        item: ArticleItemBean
    ) {
        val binding = holder.dataBinding
        binding?.item = item
        binding?.executePendingBindings()
    }
}