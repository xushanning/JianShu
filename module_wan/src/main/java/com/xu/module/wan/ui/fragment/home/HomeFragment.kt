package com.xu.module.wan.ui.fragment.home

import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.mvvm.BaseVmFragment
import com.xu.commonlib.utlis.extention.go
import com.xu.commonlib.utlis.extention.observe
import com.xu.commonlib.utlis.extention.singleDbChildDataItemClick
import com.xu.commonlib.utlis.extention.singleDbDataItemClick
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.bean.BannerBean
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WFragmentHomeBinding
import com.youth.banner.Banner
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.util.BannerUtils
import dagger.hilt.android.AndroidEntryPoint
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

        quickAdapter.run {

            singleDbDataItemClick {
                go(ARouterPath.web) {
                    withString("url", it.link)
                    withString("title", it.title)
                }
            }

            singleDbChildDataItemClick { item, viewId ->
                if (viewId == R.id.img_collect) {
                    Logger.d("收藏" + item.author)
                }
            }
        }
    }

    override fun initData() {
        mViewModel.getBannerData()
        mViewModel.getHomeData()

        observe(mViewModel.homeArticleData) {
            quickAdapter.setNewInstance(it)
        }

        observe(mViewModel.bannerLiveData) {
            if (quickAdapter.headerLayoutCount == 0) {
                val banner = Banner<BannerBean, HomeBannerAdapter>(context).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        BannerUtils.dp2px(150f).toInt()
                    )
                    adapter = HomeBannerAdapter(it)
                    addBannerLifecycleObserver(this@HomeFragment)
                    indicator = CircleIndicator(context)
                    setOnBannerListener { data, _ ->
                        data as BannerBean
                        go(ARouterPath.web) {
                            withString("url", data.url)
                            withString("title", data.title)
                        }

                    }
                }

                quickAdapter.addHeaderView(banner)
            }
        }

    }

}