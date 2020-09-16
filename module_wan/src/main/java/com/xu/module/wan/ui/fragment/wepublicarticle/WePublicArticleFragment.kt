package com.xu.module.wan.ui.fragment.wepublicarticle

import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.orhanobut.logger.Logger
import com.xu.commonlib.utlis.extention.go
import com.xu.commonlib.utlis.extention.observe
import com.xu.commonlib.utlis.extention.singleChildDataItemClick
import com.xu.commonlib.utlis.extention.singleDataItemClick
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.base.BaseFragment
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WFragmentWePublicArticleBinding
import com.xu.module.wan.ui.fragment.home.HomeArticleItemQuickAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.w_fragment_we_public_article.*

@Route(path = ARouterPath.wePublicArticleList)
@AndroidEntryPoint
class WePublicArticleFragment(
    override val layoutId: Int = R.layout.w_fragment_we_public_article,
    override val variableId: Int = BR.vm
) : BaseFragment<WePublicArticleViewModel, WFragmentWePublicArticleBinding>() {

    @Autowired(name = "id")
    @JvmField
    var id: Int? = 0

    private val quickAdapter: HomeArticleItemQuickAdapter by lazy { HomeArticleItemQuickAdapter() }

    override fun initView(mDataBinding: WFragmentWePublicArticleBinding) {
        rv_article_list.run {
            adapter = quickAdapter
            layoutManager = LinearLayoutManager(context)
        }
        quickAdapter.run {
            singleDataItemClick {
                go(ARouterPath.web) {
                    withString("url", it.link)
                    withString("title", it.title)
                }
            }

            singleChildDataItemClick { item, viewId ->
                if (viewId == R.id.img_collect) {
                    Logger.d("收藏" + item.author)
                }
            }
        }

    }

    override fun initData() {
        mViewModel.getHistoryArticleList(id!!)
        observe(mViewModel.historyArticleLiveData) {
            quickAdapter.setNewInstance(it)
        }
    }
}