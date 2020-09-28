package com.xu.module.wan.ui.fragment.navigation

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xu.module.wan.R
import com.xu.module.wan.bean.NavigationWrapBean
import me.jingbin.library.adapter.BaseByRecyclerViewAdapter
import me.jingbin.library.adapter.BaseByViewHolder
import me.jingbin.library.stickyview.StickyHeaderHandler
import javax.inject.Inject

/**
 * @author 许 on 2020/9/21.
 */
class NavigationAdapter @Inject constructor() :
    BaseByRecyclerViewAdapter<NavigationWrapBean, BaseByViewHolder<NavigationWrapBean>>() {
    companion object {
        const val NAVIGATION_TYPE_CONTENT = 0x002
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseByViewHolder<NavigationWrapBean> {
        return if (viewType == StickyHeaderHandler.TYPE_STICKY_VIEW) {
            TitleHolder(parent, R.layout.w_item_navigation_right_head)
        } else {
            ContentHolder(parent, R.layout.w_item_navigation_right_content)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (data[position].titleBean == null) {
            NAVIGATION_TYPE_CONTENT
        } else {
            StickyHeaderHandler.TYPE_STICKY_VIEW
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        val manager = recyclerView.layoutManager as GridLayoutManager
        manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (getItemViewType(position)) {
                    StickyHeaderHandler.TYPE_STICKY_VIEW -> manager.spanCount
                    else -> 1
                }
            }
        }
    }

    class TitleHolder(view: ViewGroup, layoutRes: Int) :
        BaseByViewHolder<NavigationWrapBean>(view, layoutRes) {
        override fun onBaseBindView(holder: BaseByViewHolder<NavigationWrapBean>?, bean: NavigationWrapBean?, position: Int) {
            holder?.itemView?.findViewById<TextView>(R.id.tv_head_name)?.text =
                bean?.titleBean?.name
        }
    }

    class ContentHolder(view: ViewGroup, layoutRes: Int) :
        BaseByViewHolder<NavigationWrapBean>(view, layoutRes) {
        override fun onBaseBindView(holder: BaseByViewHolder<NavigationWrapBean>?, bean: NavigationWrapBean?, position: Int) {
            holder?.itemView?.findViewById<TextView>(R.id.tv_content_name)?.text =
                bean?.contentBean?.title
        }

    }

}