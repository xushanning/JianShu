package com.xu.module.wan.utils.ext

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xu.module.wan.base.BasePagingAdapter
import com.xu.module.wan.base.BasePagingBindingHolder
import com.xu.module.wan.base.BasePagingViewHolder

/**
 * @author 许 on 2020/9/22.
 * 创建adapter ext
 */

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

/**
 * 创建普通的Adapter
 */
fun <T> createAdapter(layout: Int, convert: (holder: BaseViewHolder, item: T) -> Unit): BaseQuickAdapter<T, BaseViewHolder> {
    return object : BaseQuickAdapter<T, BaseViewHolder>(layout) {
        override fun convert(holder: BaseViewHolder, item: T) {
            convert.invoke(holder, item)
        }
    }
}

/**
 * 带有binding的普通adapter
 */
fun <T, BD : ViewDataBinding> createBindingAdapter(layout: Int, convert: (holder: BaseDataBindingHolder<BD>, item: T) -> Unit): BaseQuickAdapter<T, BaseDataBindingHolder<BD>> {
    return object : BaseQuickAdapter<T, BaseDataBindingHolder<BD>>(layout) {
        override fun convert(holder: BaseDataBindingHolder<BD>, item: T) {
            convert.invoke(holder, item)
        }
    }
}

/**
 * 创建pagingAdapter
 */
fun <T : Any> createPagingAdapter(layout: Int, itemsTheSame: (oldItem: T, newItem: T) -> Boolean, contentsTheSame: (oldItem: T, newItem: T) -> Boolean, convert: (holder: BasePagingViewHolder, item: T) -> Unit): BasePagingAdapter<T, BasePagingViewHolder> {
    return object :
        BasePagingAdapter<T, BasePagingViewHolder>(layout, itemsTheSame, contentsTheSame) {
        override fun convert(holder: BasePagingViewHolder, item: T) {
            convert.invoke(holder, item)
        }

    }
}

/**
 * 创建DataBinding的adapter
 */
fun <T : Any, BD : ViewDataBinding> createPageBindingAdapter(layout: Int, itemsTheSame: (oldItem: T, newItem: T) -> Boolean, contentsTheSame: (oldItem: T, newItem: T) -> Boolean, convert: (holder: BasePagingBindingHolder<BD>, item: T) -> Unit): BasePagingAdapter<T, BasePagingBindingHolder<BD>> {
    return object :
        BasePagingAdapter<T, BasePagingBindingHolder<BD>>(layout, itemsTheSame, contentsTheSame) {
        override fun convert(holder: BasePagingBindingHolder<BD>, item: T) {
            convert.invoke(holder, item)
        }

    }
}