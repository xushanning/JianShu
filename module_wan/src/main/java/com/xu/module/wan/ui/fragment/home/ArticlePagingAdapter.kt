package com.xu.module.wan.ui.fragment.home

import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.xu.commonlib.utlis.extention.load
import com.xu.module.wan.R
import com.xu.module.wan.base.BasePagingMultiAdapter
import com.xu.module.wan.base.BaseViewHolder
import com.xu.module.wan.bean.ArticleItemBean
import com.xu.module.wan.bean.TagBean
import com.xu.module.wan.bean.local.CollectStateBean
import com.xu.module.wan.databinding.WItemArticleBinding
import com.xu.module.wan.databinding.WItemProjectBinding
import javax.inject.Inject

class ArticlePagingAdapter @Inject constructor() :
    BasePagingMultiAdapter<ArticleItemBean, BaseViewHolder>(
        { oldItem, newItem ->
            oldItem.id == newItem.id
        }, { oldItem, newItem ->
            oldItem.collect == newItem.collect
        }) {
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

        /**
         * 处理收藏状态
         */
        @JvmStatic
        @BindingAdapter("collectState")
        fun setCollectImage(img: ImageView, collect: Boolean) {
            val imgRes = if (collect) {
                R.drawable.w_vector_collect
            } else {
                R.drawable.w_vector_un_collect
            }
            img.setImageResource(imgRes)
        }

        @JvmStatic
        @BindingAdapter("articleTitle")
        fun setTitle(tv: TextView, title: String) {
            tv.text = Html.fromHtml(title,Html.FROM_HTML_MODE_LEGACY)
        }
    }

    init {
        addItemType(TYPE_ARTICLE, R.layout.w_item_article)
        addItemType(TYPE_PROJECT, R.layout.w_item_project)
        addChildClickViewIds(R.id.img_collect)
    }

    override fun convert(holder: BaseViewHolder, item: ArticleItemBean) {
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

    /**
     * 变更item的收藏状态
     */
    fun changeCollectState(state: CollectStateBean) {
        getItem(state.position)?.collect = state.collectState
        notifyItemChanged(state.position)
    }
}