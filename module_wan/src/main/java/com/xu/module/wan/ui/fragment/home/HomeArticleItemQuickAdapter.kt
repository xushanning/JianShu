package com.xu.module.wan.ui.fragment.home

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xu.commonlib.utlis.extention.load
import com.xu.module.wan.R
import com.xu.module.wan.bean.ArticleItemBean
import com.xu.module.wan.bean.TagBean
import com.xu.module.wan.databinding.WItemArticleBinding
import com.xu.module.wan.databinding.WItemProjectBinding

class HomeArticleItemQuickAdapter :
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

        @JvmStatic
        @BindingAdapter("author", "shareUser")
        fun handleAuthor(view: TextView, author: String, shareUser: String) {
            //如果author不为空，那么用author字段，如果为空，用shareUser字段
            view.text = if (author.isNotEmpty()) {
                author
            } else {
                shareUser
            }
        }

        @JvmStatic
        @BindingAdapter("handleTags")
        fun handleTags(view: TextView, tags: List<TagBean>) {
            if (tags.isEmpty()) {
                view.visibility = View.GONE
            } else {
                view.text = tags[0].name
            }
        }

        @JvmStatic
        @BindingAdapter("chapterName", "superChapterName")
        fun handleChapter(view: TextView, chapterName: String, superChapterName: String) {
            view.text = "$chapterName·$superChapterName"
        }

        @JvmStatic
        @BindingAdapter("imgUrl")
        fun loadImage(view: ImageView, url: String) {
            view.load(url)
        }

    }
}