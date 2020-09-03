package com.xu.module.wan.ui.fragment.home

import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.mvvm.BaseVmFragment
import com.xu.commonlib.utlis.extention.observe
import com.xu.commonlib.utlis.extention.singleDataItemClick
import com.xu.commonlib.utlis.extention.singleItemClick
import com.xu.module.wan.R
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WFragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import com.xu.module.wan.BR
import kotlinx.android.synthetic.main.w_fragment_home.*

@Route(path = ARouterPath.home)
@AndroidEntryPoint
class HomeFragment(
    override val layoutId: Int = R.layout.w_fragment_home,
    override val variableId: Int = BR.vm
) : BaseVmFragment<HomeViewModel, WFragmentHomeBinding>() {

    private val quickAdapter = HomeArticleItemQuickAdapter()

    override fun initView(mDataBinding: WFragmentHomeBinding) {
        rv_home.layoutManager = LinearLayoutManager(context)
        rv_home.adapter = quickAdapter

    }

    override fun initData() {
        mViewModel.getHomeData()

        observe(mViewModel.homeArticleData) {
            Logger.d(it.size)
            quickAdapter.data = it
        }
    }

}