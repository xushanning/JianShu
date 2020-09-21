package com.xu.module.wan.ui.fragment.navigation

import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.orhanobut.logger.Logger
import com.xu.commonlib.utlis.extention.observe
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.base.BaseFragment
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WIncludeListBinding
import com.xu.module.wan.utils.ext.initFloatButton
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.w_include_list.*
import javax.inject.Inject

/**
 * @author 许 on 2020/9/21.
 * 导航栏
 */
@Route(path = ARouterPath.stationNavigation)
@AndroidEntryPoint
class NavigationFragment(override val layoutId: Int = R.layout.w_include_list, override val variableId: Int = BR.vm) :
    BaseFragment<NavigationViewModel, WIncludeListBinding>() {
    @Inject
    lateinit var adapter: NavigationAdapter
    override fun initView(mDataBinding: WIncludeListBinding) {
        rv_list.run {
            adapter = this@NavigationFragment.adapter
            layoutManager = LinearLayoutManager(requireContext())
            initFloatButton(float_bt)
        }
        swipe_refresh.isEnabled = false
    }

    override fun initData() {
        mViewModel.getNavigationData()
        observe(mViewModel.navigationLiveData) {
            adapter.setNewInstance(it)
        }
    }
}