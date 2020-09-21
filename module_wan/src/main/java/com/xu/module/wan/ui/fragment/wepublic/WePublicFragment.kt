package com.xu.module.wan.ui.fragment.wepublic

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.tabs.TabLayoutMediator
import com.orhanobut.logger.Logger
import com.xu.commonlib.utlis.extention.getFragment
import com.xu.commonlib.utlis.extention.observe
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.base.BaseFragment
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WFragmentWePublicBinding
import com.xu.module.wan.utils.ext.getHotKey
import com.xu.module.wan.viewmodel.HotKeyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.w_fragment_we_public.*

/**
 * 微信公众号
 */
@Route(path = ARouterPath.wePublic)
@AndroidEntryPoint
class WePublicFragment(
    override val layoutId: Int = R.layout.w_fragment_we_public,
    override val variableId: Int = BR.vm
) : BaseFragment<WePublicViewModel, WFragmentWePublicBinding>() {

    override fun initView(mDataBinding: WFragmentWePublicBinding) {

    }

    override fun initData() {
        mViewModel.getWePublicAccountList()
        observe(mViewModel.wePublicAccountLiveData) {
            vp_we_public.adapter = object : FragmentStateAdapter(this) {

                override fun getItemCount(): Int {
                    return it.size
                }


                override fun createFragment(position: Int): Fragment {
                    return getFragment(ARouterPath.wePublicArticleList) {
                        withInt("id", it[position].id)
                    }
                }
            }
            //联动
            TabLayoutMediator(tl_we_public, vp_we_public) { tab, position ->
                tab.text = it[position].name
            }.attach()
        }

        val hotKeyViewModel = ViewModelProvider(requireActivity()).get(HotKeyViewModel::class.java)
        observe(hotKeyViewModel.hotKeyLiveData) {
            v_search.setHotKey(it.getHotKey())
        }
    }
}