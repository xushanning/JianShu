package com.xu.module.wan.ui.fragment.square

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.tabs.TabLayoutMediator
import com.xu.commonlib.utlis.extention.getFragment
import com.xu.commonlib.utlis.extention.observe
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.base.BaseFragment
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WFragmentSquareBinding
import com.xu.module.wan.utils.ext.getHotKey
import com.xu.module.wan.viewmodel.HotKeyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.w_fragment_square.*
import kotlinx.android.synthetic.main.w_include_viewpager.*


/**
 * 广场fragment
 */
@Route(path = ARouterPath.square)
@AndroidEntryPoint
class SquareFragment(
    override val layoutId: Int = R.layout.w_fragment_square,
    override val variableId: Int = BR.vm
) : BaseFragment<SquareViewModel, WFragmentSquareBinding>() {
    override fun initView(mDataBinding: WFragmentSquareBinding) {
        val tabName = listOf("知识体系", "导航")

        view_pager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return tabName.size
            }

            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> getFragment(ARouterPath.knowledgeSystem)
                    1 -> getFragment(ARouterPath.stationNavigation)
                    else -> getFragment(ARouterPath.knowledgeSystem)
                }
            }
        }
        TabLayoutMediator(tab_layout, view_pager) { tab, position ->
            tab.text = tabName[position]
        }.attach()
    }

    override fun initData() {
        val hotKeyViewModel = ViewModelProvider(requireActivity()).get(HotKeyViewModel::class.java)
        observe(hotKeyViewModel.hotKeyLiveData) {
            v_search.setHotKey(it.getHotKey())
        }
    }
}