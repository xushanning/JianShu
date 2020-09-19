package com.xu.module.wan.utils.ext

import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.xu.module.wan.base.BasePagingAdapter
import com.xu.module.wan.base.BaseViewHolder
import com.xu.module.wan.bean.ArticleItemBean


fun <T> PagingDataAdapter<Any, RecyclerView.ViewHolder>.singleClick() {


}

/**
 * 创建diff
 */
fun <T : Any> createDiff(itemsTheSame: (oldItem: T, newItem: T) -> Boolean, contentsTheSame: (oldItem: T, newItem: T) -> Boolean): DiffUtil.ItemCallback<T> {
    return object : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return itemsTheSame.invoke(oldItem, newItem)
        }

        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return contentsTheSame.invoke(oldItem, newItem)
        }
    }

}