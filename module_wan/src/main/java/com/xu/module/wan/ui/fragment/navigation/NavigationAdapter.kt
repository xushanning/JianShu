package com.xu.module.wan.ui.fragment.navigation

import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.google.android.flexbox.FlexboxLayoutManager
import com.xu.module.wan.R
import com.xu.module.wan.bean.NavigationBean
import javax.inject.Inject

/**
 * @author 许 on 2020/9/21.
 */
class NavigationAdapter @Inject constructor() :
    BaseQuickAdapter<NavigationBean, BaseViewHolder>(R.layout.w_item_navigation) {
    override fun convert(holder: BaseViewHolder, item: NavigationBean) {
        holder.setText(R.id.tv_name, item.name)
        holder.getView<RecyclerView>(R.id.rv_navigation_item).run {
            adapter = NavigationChildAdapter(item.articles)
            layoutManager = FlexboxLayoutManager(context)
        }
    }


}