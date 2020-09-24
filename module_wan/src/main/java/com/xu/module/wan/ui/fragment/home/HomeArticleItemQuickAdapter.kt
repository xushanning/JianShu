package com.xu.module.wan.ui.fragment.home

import androidx.databinding.DataBindingUtil
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xu.module.wan.R
import com.xu.module.wan.bean.ArticleItemBean
import com.xu.module.wan.databinding.WItemArticleBinding
import com.xu.module.wan.databinding.WItemProjectBinding
import javax.inject.Inject

class HomeArticleItemQuickAdapter @Inject constructor() :
    BaseMultiItemQuickAdapter<ArticleItemBean, BaseViewHolder>(ArrayList()) {
    init {
        addItemType(TYPE_ARTICLE, R.layout.w_item_article)
        addItemType(TYPE_PROJECT, R.layout.w_item_project)
    }


    override fun convert(holder: BaseViewHolder, item: ArticleItemBean) {
        when (item.itemType) {
            TYPE_ARTICLE -> {
                addChildClickViewIds(R.id.img_collect)
                val binding = DataBindingUtil.bind<WItemArticleBinding>(holder.itemView)
                binding?.item = item
                binding?.executePendingBindings()
            }
            TYPE_PROJECT -> {
                addChildClickViewIds(R.id.img_collect)
                val binding = DataBindingUtil.bind<WItemProjectBinding>(holder.itemView)
                binding?.item = item
                binding?.executePendingBindings()
            }
        }
    }


    companion object {
        /**
         * 文章
         */
        const val TYPE_ARTICLE = 1

        /**
         * 项目
         */
        const val TYPE_PROJECT = 2


    }
}