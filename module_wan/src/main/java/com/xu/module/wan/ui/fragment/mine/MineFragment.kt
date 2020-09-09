package com.xu.module.wan.ui.fragment.mine

import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.base.mvvm.BaseVmFragment
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WFragmentMineBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * 我的
 */
@Route(path = ARouterPath.home)
@AndroidEntryPoint
class MineFragment(
    override val layoutId: Int = R.layout.w_fragment_mine,
    override val variableId: Int = BR.vm
) : BaseVmFragment<MineViewModel, WFragmentMineBinding>() {
    override fun initView(mDataBinding: WFragmentMineBinding) {

    }

    override fun initData() {

    }
}