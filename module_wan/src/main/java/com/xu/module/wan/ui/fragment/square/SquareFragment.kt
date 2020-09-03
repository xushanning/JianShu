package com.xu.module.wan.ui.fragment.square

import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.base.mvvm.BaseVmFragment
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WFragmentSquareBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * 广场fragment
 */
@Route(path = ARouterPath.square)
@AndroidEntryPoint
class SquareFragment(
    override val layoutId: Int = R.layout.w_fragment_square,
    override val variableId: Int = BR.vm
) : BaseVmFragment<SquareViewModel, WFragmentSquareBinding>() {
    override fun initView(mDataBinding: WFragmentSquareBinding) {

    }

    override fun initData() {
    }
}