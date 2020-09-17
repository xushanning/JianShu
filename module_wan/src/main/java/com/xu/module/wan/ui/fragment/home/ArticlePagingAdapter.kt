package com.xu.module.wan.ui.fragment.home

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.xu.module.wan.R
import com.xu.module.wan.base.BasePagingMultiAdapter
import com.xu.module.wan.base.BaseViewHolder
import com.xu.module.wan.bean.ArticleItemBean
import com.xu.module.wan.databinding.WItemArticleBinding
import com.xu.module.wan.databinding.WItemProjectBinding
import javax.inject.Inject

class ArticlePagingAdapter @Inject constructor() :
    BasePagingMultiAdapter<ArticleItemBean, BaseViewHolder>(diff) {

    companion object {
        private val diff = object : DiffUtil.ItemCallback<ArticleItemBean>() {
            override fun areItemsTheSame(oldItem: ArticleItemBean, newItem: ArticleItemBean): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ArticleItemBean, newItem: ArticleItemBean): Boolean {
                return oldItem.id == newItem.id
            }
        }

        /**
         * 文章
         */
        const val TYPE_ARTICLE = 1

        /**
         * 项目
         */
        const val TYPE_PROJECT = 2
    }

    init {
        addItemType(TYPE_ARTICLE, R.layout.w_item_article)
        addItemType(TYPE_PROJECT, R.layout.w_item_project)
    }

    override fun convert(holder: BaseViewHolder, item: ArticleItemBean) {
        addChildClickViewIds(R.id.img_collect)
        when (item.itemType) {
            TYPE_ARTICLE -> {
                DataBindingUtil.bind<WItemArticleBinding>(holder.itemView)?.item = item
            }
            TYPE_PROJECT -> {
                DataBindingUtil.bind<WItemProjectBinding>(holder.itemView)?.item = item
            }
        }
    }

    override fun getDefItemViewType(position: Int): Int {
        return if (getItem(position)!!.envelopePic.isEmpty()) {
            TYPE_ARTICLE
        } else {
            TYPE_PROJECT
        }
    }
}