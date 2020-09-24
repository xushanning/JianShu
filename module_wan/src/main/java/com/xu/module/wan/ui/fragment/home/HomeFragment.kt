package com.xu.module.wan.ui.fragment.home

import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.orhanobut.logger.Logger
import com.xu.commonlib.utlis.extention.go
import com.xu.commonlib.utlis.extention.observe
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.base.BaseFragment
import com.xu.module.wan.bean.BannerBean
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WFragmentHomeBinding
import com.xu.module.wan.utils.ext.getHotKey
import com.xu.module.wan.utils.ext.initFloatButton
import com.xu.module.wan.viewmodel.ArticleCollectViewModel
import com.xu.module.wan.viewmodel.HotKeyViewModel
import com.youth.banner.Banner
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.util.BannerUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.w_fragment_home.*
import javax.inject.Inject

@Route(path = ARouterPath.home)
@AndroidEntryPoint
class HomeFragment(
    override val layoutId: Int = R.layout.w_fragment_home,
    override val variableId: Int = BR.vm
) : BaseFragment<HomeViewModel, WFragmentHomeBinding>() {

    private val collectViewModel: ArticleCollectViewModel by viewModels()


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
                        swipe_refresh.isRefreshing = true
                        Logger.d("正在加载")
                    }
                    is LoadState.Error -> {

                    }
                    is LoadState.NotLoading -> {
                        swipe_refresh.isRefreshing = false
                        Logger.d("加载完了")
                    }

                }
            }

            setOnItemClickListener { item, _ ->
                go(ARouterPath.web) {
                    withString("url", item.link)
                    withString("title", item.title)
                    withObject("bean", item)
                }
            }
            setOnItemChildClickListener { item, position, viewId ->
                if (viewId == R.id.img_collect) {
                    if (item.collect) {
                        collectViewModel.unCollectArticleList(item.id, position)
                    } else {
                        collectViewModel.collectInnerArticle(item.id, position)
                    }
                }
            }
        }

        swipe_refresh.setOnRefreshListener {
            pagingAdapter.refresh()
        }
    }

    override fun initData() {
//        loadService = inject(rv_home)
        mViewModel.getBannerData()
        // hotKeyViewModel.getHotKey()

//        observe(mViewModel.homeArticleData) {
//            loadService.showSuccess()
//            quickAdapter.setNewInstance(it)
//        }

        val hotKeyViewModel = ViewModelProvider(requireActivity()).get(HotKeyViewModel::class.java)
        observe(hotKeyViewModel.hotKeyLiveData) {
            v_search.setHotKey(it.getHotKey())
        }

        observe(collectViewModel.collectStateLiveData) {
            pagingAdapter.changeCollectState(it)
        }

        observe(pagingAdapter, mViewModel.pager)

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

                //pagingAdapter.addHeaderView(banner)
            }
        }

    }

}