package com.xu.module.wan.ui.fragment.navigation

import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.google.android.flexbox.FlexboxLayoutManager
import com.xu.commonlib.utlis.extention.go
import com.xu.commonlib.utlis.extention.singleDataItemClick
import com.xu.module.wan.R
import com.xu.module.wan.bean.NavigationBean
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.constant.WebSourceConstant
import javax.inject.Inject

/**
 * @author 许 on 2020/9/21.
 */
class NavigationAdapter @Inject constructor() :
    BaseQuickAdapter<NavigationBean, BaseViewHolder>(R.layout.w_item_navigation) {
    override fun convert(holder: BaseViewHolder, item: NavigationBean) {
        holder.setText(R.id.tv_name, item.name)
        holder.getView<RecyclerView>(R.id.rv_navigation_item).run {
            setItemViewCacheSize(200)
            setHasFixedSize(true)
            adapter = NavigationChildAdapter(item.articles).apply {
                singleDataItemClick {
                    go(ARouterPath.web) {
                        withString("title", it.title)
                        withString("url", it.link)
                        withString("source", WebSourceConstant.SOURCE_NAVIGATION)
                    }
                }
            }
            layoutManager = FlexboxLayoutManager(context)
        }
    }


}