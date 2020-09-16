package com.xu.module.wan.ui.fragment.home

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.xu.module.wan.bean.ArticleItemBean

/**
 * @author 许 on 2020/9/16.
 */
//class ArticlePagingAdapter :
//    PagingDataAdapter<ArticleItemBean, RecyclerView.ViewHolder>(ArticleDiff()) {
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//
//    }
//
//    class ArticleDiff : DiffUtil.ItemCallback<ArticleItemBean>() {
//        override fun areItemsTheSame(oldItem: ArticleItemBean, newItem: ArticleItemBean): Boolean {
//            return oldItem.id == newItem.id
//        }
//
//        override fun areContentsTheSame(oldItem: ArticleItemBean, newItem: ArticleItemBean): Boolean {
//            return oldItem.id == newItem.id
//        }
//
//    }
//}