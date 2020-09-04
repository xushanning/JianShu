package com.xu.commonlib.utlis.extention

import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * @author 言吾許
 */

private object QuickAdapterClick {
    var delayTime = 0L
    var lastClickTime = 0L
}

/**
 * BaseQuickAdapter item防重点
 */
fun <T> BaseQuickAdapter<T, BaseViewHolder>.singleItemClick(
    time: Long = 1000,
    block: (position: Int) -> Unit
) {
    QuickAdapterClick.delayTime = time
    setOnItemClickListener { _, _, position ->
        if (clickEnable()) {
            block(position)
        }
    }
}

/**
 * BaseQuickAdapter带数据的 item防重点
 */
fun <T> BaseQuickAdapter<T, BaseViewHolder>.singleDataItemClick(
    time: Long = 1000,
    block: (item: T) -> Unit
) {
    QuickAdapterClick.delayTime = time
    setOnItemClickListener { _, _, position ->
        if (clickEnable()) {
            block(data[position])
        }
    }
}

/**
 * BaseQuickAdapter item子view防重点
 */
fun <T> BaseQuickAdapter<T, BaseViewHolder>.singleChildItemClick(
    time: Long = 1000,
    block: (position: Int, viewId: Int) -> Unit
) {
    QuickAdapterClick.delayTime = time
    setOnItemChildClickListener { _, view, position ->
        if (clickEnable()) {
            block(position, view.id)
        }
    }
}

/**
 * BaseQuickAdapter 带数据的item子view防重点
 */
fun <T> BaseQuickAdapter<T, BaseViewHolder>.singleChildDataItemClick(
    time: Long = 1000,
    block: (item: T, viewId: Int) -> Unit
) {
    QuickAdapterClick.delayTime = time
    setOnItemChildClickListener { _, view, position ->
        if (clickEnable()) {
            block(data[position], view.id)
        }
    }
}

fun <T, D : ViewDataBinding> BaseQuickAdapter<T, BaseDataBindingHolder<D>>.singleDbItemClick(
    time: Long = 1000,
    block: (position: Int) -> Unit
) {
    QuickAdapterClick.delayTime = time
    setOnItemClickListener { _, _, position ->
        if (clickEnable()) {
            block(position)
        }
    }
}

/**
 * BaseQuickAdapter DataBinding带数据的 item防重点
 */
fun <T, D : ViewDataBinding> BaseQuickAdapter<T, BaseDataBindingHolder<D>>.singleDbDataItemClick(
    time: Long = 1000,
    block: (item: T) -> Unit
) {
    QuickAdapterClick.delayTime = time
    setOnItemClickListener { _, _, position ->
        if (clickEnable()) {
            block(data[position])
        }
    }
}

/**
 * BaseQuickAdapter DataBinding item子view防重点
 */
fun <T, D : ViewDataBinding> BaseQuickAdapter<T, BaseDataBindingHolder<D>>.singleDbChildItemClick(
    time: Long = 1000,
    block: (position: Int, viewId: Int) -> Unit
) {
    QuickAdapterClick.delayTime = time
    setOnItemChildClickListener { _, view, position ->
        if (clickEnable()) {
            block(position, view.id)
        }
    }
}

/**
 * BaseQuickAdapter 带数据的item子view防重点
 */
fun <T, D : ViewDataBinding> BaseQuickAdapter<T, BaseDataBindingHolder<D>>.singleDbChildDataItemClick(
    time: Long = 1000,
    block: (item: T, viewId: Int) -> Unit
) {
    QuickAdapterClick.delayTime = time
    setOnItemChildClickListener { _, view, position ->
        if (clickEnable()) {
            block(data[position], view.id)
        }
    }
}


private fun clickEnable(): Boolean {
    var flag = false
    val currentClickTime = System.currentTimeMillis()
    if (currentClickTime - QuickAdapterClick.lastClickTime >= QuickAdapterClick.delayTime) {
        QuickAdapterClick.lastClickTime = currentClickTime
        flag = true
    }
    return flag
}

