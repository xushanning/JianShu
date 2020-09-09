package com.xu.module.wan.ui.fragment.wepublic

import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.base.mvvm.BaseVmFragment
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WFragmentWePublicBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * 微信公众号
 */
@Route(path = ARouterPath.home)
@AndroidEntryPoint
class WePublic(
    override val layoutId: Int = R.layout.w_fragment_we_public,
    override val variableId: Int = BR.vm
) : BaseVmFragment<WePublicViewModel, WFragmentWePublicBinding>() {
    override fun initView(mDataBinding: WFragmentWePublicBinding) {

    }

    override fun initData() {
    }
}