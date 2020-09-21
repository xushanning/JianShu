package com.xu.module.wan.ui.fragment.navigation

import android.graphics.Color
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xu.module.wan.R
import com.xu.module.wan.bean.ArticleBean

/**
 * @author 许 on 2020/9/21.
 */
class NavigationChildAdapter(data: MutableList<ArticleBean>) :
    BaseQuickAdapter<ArticleBean, BaseViewHolder>(R.layout.w_item_navigation_child, data) {
    override fun convert(holder: BaseViewHolder, item: ArticleBean) {
        holder.setText(R.id.tv_name, item.title)
            .setTextColor(R.id.tv_name, randomColor())
    }

    private fun randomColor(): Int {
        val red = (0..190).random()
        val green = (0..190).random()
        val blue = (0..190).random()
        return Color.rgb(red, green, blue)
    }
}