package com.xu.module.wan.ui.activity.search

import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.base.BaseActivity
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WActivitySearchBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * 搜索
 */
@Route(path = ARouterPath.search)
@AndroidEntryPoint
class SearchActivity(override val layoutId: Int = R.layout.w_activity_search, override val variableId: Int = BR.vm) :
    BaseActivity<SearchViewModel, WActivitySearchBinding>() {
    override fun initView(mDataBinding: WActivitySearchBinding) {

    }

    override fun initData() {

     }
}