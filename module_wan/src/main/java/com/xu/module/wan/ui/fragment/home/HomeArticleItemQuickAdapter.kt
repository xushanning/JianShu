package com.xu.module.wan.ui.fragment.home

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.xu.module.wan.R
import com.xu.module.wan.bean.ArticleItemBean
import com.xu.module.wan.bean.TagBean
import com.xu.module.wan.databinding.WItemArticleBinding

class HomeArticleItemQuickAdapter :
    BaseQuickAdapter<ArticleItemBean, BaseDataBindingHolder<WItemArticleBinding>>(R.layout.w_item_article) {

    override fun convert(
        holder: BaseDataBindingHolder<WItemArticleBinding>,
        item: ArticleItemBean
    ) {
        addChildClickViewIds(R.id.img_collect)
        val binding = holder.dataBinding
        binding?.item = item
        binding?.executePendingBindings()
    }

    companion object {
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
    }
}