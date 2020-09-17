package com.xu.module.wan.ui.fragment.home

import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.orhanobut.logger.Logger
import com.xu.commonlib.utlis.extention.go
import com.xu.commonlib.utlis.extention.observe
import com.xu.easyload.ext.inject
import com.xu.easyload.service.ILoadService
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.base.BaseFragment
import com.xu.module.wan.bean.BannerBean
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WFragmentHomeBinding
import com.xu.module.wan.utils.ext.initFloatButton
import com.xu.module.wan.viewmodel.ArticleCollectViewModel
import com.youth.banner.Banner
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.util.BannerUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.w_fragment_home.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@Route(path = ARouterPath.home)
@AndroidEntryPoint
class HomeFragment(
    override val layoutId: Int = R.layout.w_fragment_home,
    override val variableId: Int = BR.vm
) : BaseFragment<HomeViewModel, WFragmentHomeBinding>() {

    val collectViewModel: ArticleCollectViewModel by viewModels()


    @Inject
    lateinit var pagingAdapter: ArticlePagingAdapter


    override fun initView(mDataBinding: WFragmentHomeBinding) {
        rv_home.layoutManager = LinearLayoutManager(context)
        rv_home.adapter = pagingAdapter
        rv_home.initFloatButton(float_bt)

        pagingAdapter.run {
            //todo 增加加载footer
            //withLoadStateFooter()
            addLoadStateListener {

                when (it.refresh) {
                    is LoadState.Loading -> {
                        Logger.d("正在加载")
                    }
                    is LoadState.Error -> {

                    }
                    is LoadState.NotLoading -> {
                        Logger.d("加载完了")
                    }

                }
            }

            setOnItemClickListener { item, _ ->
                go(ARouterPath.web) {
                    withString("url", item.link)
                    withString("title", item.title)
                }
            }
            setOnItemChildClickListener { item, position, view ->
                if (view.id == R.id.img_collect) {
                    Logger.d("收藏被点击了" + position + item.title)
                }
            }
        }

        swipe_refresh.setOnRefreshListener {
            Logger.d("刷新")
            pagingAdapter.refresh()
        }
    }

    override fun initData() {
//        loadService = inject(rv_home)
        mViewModel.getBannerData()
        //  mViewModel.getHomeData()

//        observe(mViewModel.homeArticleData) {
//            loadService.showSuccess()
//            quickAdapter.setNewInstance(it)
//        }

        lifecycleScope.launch {
            mViewModel.pager.collectLatest {
                pagingAdapter.submitData(it)
            }
        }


        observe(mViewModel.bannerLiveData) {
            if (pagingAdapter.headerLayoutCount == 0) {
                val banner = Banner<BannerBean, HomeBannerAdapter>(context).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        BannerUtils.dp2px(200f).toInt()
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

                pagingAdapter.addHeaderView(banner)
            }
        }

    }

}