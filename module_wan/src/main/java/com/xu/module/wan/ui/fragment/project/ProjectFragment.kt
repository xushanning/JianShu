package com.xu.module.wan.ui.fragment.project

import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.base.mvvm.BaseVmFragment
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WFragmentProjectBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * 广场fragment
 */
@Route(path = ARouterPath.project)
@AndroidEntryPoint
class ProjectFragment(
    override val layoutId: Int = R.layout.w_fragment_project,
    override val variableId: Int = BR.vm
) : BaseVmFragment<ProjectViewModel, WFragmentProjectBinding>() {
    override fun initView(mDataBinding: WFragmentProjectBinding) {

    }

    override fun initData() {
    }
}