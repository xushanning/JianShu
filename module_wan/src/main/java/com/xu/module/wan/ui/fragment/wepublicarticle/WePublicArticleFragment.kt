package com.xu.module.wan.ui.fragment.wepublicarticle

import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.orhanobut.logger.Logger
import com.xu.commonlib.utlis.extention.go
import com.xu.commonlib.utlis.extention.observe
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.base.BaseFragment
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WFragmentWePublicArticleBinding
import com.xu.module.wan.ui.fragment.home.ArticlePagingAdapter
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

    private val quickAdapter by lazy { ArticlePagingAdapter() }

    override fun initView(mDataBinding: WFragmentWePublicArticleBinding) {
        rv_article_list.run {
            adapter = quickAdapter
            layoutManager = LinearLayoutManager(context)
        }
        quickAdapter.run {
            setOnItemClickListener { item, _ ->
                go(ARouterPath.web) {
                    withString("url", item.link)
                    withString("title", item.title)
                }
            }
            setOnItemChildClickListener { item, _, viewId ->
                if (viewId == R.id.img_collect) {
                    Logger.d("收藏" + item.author)
                }
            }
        }

    }

    override fun initData() {
        observe(quickAdapter, mViewModel.getHistoryArticleList(id!!))
    }
}