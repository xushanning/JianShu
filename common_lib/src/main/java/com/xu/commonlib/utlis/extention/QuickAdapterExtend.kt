package com.xu.commonlib.utlis.extention

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

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
fun <T> BaseQuickAdapter<T, BaseViewHolder>.singleItemClick(time: Long = 1000, block: (position: Int) -> Unit) {
    QuickAdapterClick.delayTime = time
    setOnItemClickListener { _, _, position ->
        if (clickEnable()) {
            block(position)
        }
    }
}

/**
 * BaseQuickAdapter item子view防重点
 */
fun <T> BaseQuickAdapter<T, BaseViewHolder>.singleChildItemClick(time: Long = 1000, block: (position: Int, viewId: Int) -> Unit) {
    QuickAdapterClick.delayTime = time
    setOnItemChildClickListener { _, view, position ->
        if (clickEnable()) {
            block(position, view.id)
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

