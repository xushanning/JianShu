package com.xu.module.wan.base

import android.util.SparseIntArray
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil

abstract class BasePagingMultiAdapter<T : Any, VH : BaseViewHolder>(itemsTheSame: (oldItem: T, newItem: T) -> Boolean, contentsTheSame: (oldItem: T, newItem: T) -> Boolean) :
    BasePagingAdapter<T, VH>(0, itemsTheSame, contentsTheSame) {
    private val layouts: SparseIntArray by lazy(LazyThreadSafetyMode.NONE) { SparseIntArray() }

    override fun onCreateDefViewHolder(parent: ViewGroup, viewType: Int): VH {
        val layoutResId = layouts.get(viewType)
        return createBaseViewHolder(parent, layoutResId)
    }

    protected fun addItemType(type: Int, @LayoutRes layoutResId: Int) {
        layouts.put(type, layoutResId)
    }
}