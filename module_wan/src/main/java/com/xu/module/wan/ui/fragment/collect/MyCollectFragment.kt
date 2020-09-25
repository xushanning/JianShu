package com.xu.module.wan.ui.fragment.collect

import android.os.Handler
import androidx.fragment.app.viewModels
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
import com.xu.module.wan.databinding.WFragmentCollectBinding
import com.xu.module.wan.ui.fragment.home.ArticlePagingAdapter
import com.xu.module.wan.ui.fragment.home.HomeArticleItemQuickAdapter
import com.xu.module.wan.utils.ext.initFloatButton
import com.xu.module.wan.viewmodel.ArticleCollectViewModel
import com.xu.module.wan.viewmodel.ReadHistoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.w_include_list.*
import javax.inject.Inject

/**
 * 我的收藏
 */
@Route(path = ARouterPath.myCollect)
@AndroidEntryPoint
class MyCollectFragment(override val layoutId: Int = R.layout.w_fragment_collect, override val variableId: Int = BR.vm) :
    BaseFragment<MyCollectViewModel, WFragmentCollectBinding>() {
    /**
     * 类型：
     * 0：文章收藏
     * 1：网站收藏
     * 2:浏览历史
     */
    @Autowired(name = "type")
    @JvmField
    var type: Int = 0

    @Inject
    lateinit var collectArticleAdapter: MyCollectArticleAdapter

    @Inject
    lateinit var articleAdapter: HomeArticleItemQuickAdapter


    private val collectViewModel: ArticleCollectViewModel by viewModels()

    /**
     * 阅读历史ViewModel
     */
    private val readHistoryViewModel: ReadHistoryViewModel by viewModels()


    override fun initView(mDataBinding: WFragmentCollectBinding) {
        mDataBinding.click = OnClick()
        rv_list.run {
            layoutManager = LinearLayoutManager(context)
            initFloatButton(float_bt)
        }
    }

    override fun initData() {
        mViewModel.typeLiveData.postValue(type)
        when (type) {
            0, 1 -> {
                rv_list.adapter = collectArticleAdapter
                observe(mViewModel.loginState) {
                    if (it) {
                        observe(collectArticleAdapter, collectViewModel.myCollectArticleLiveData)
                    }
                }
            }
            2 -> {
                rv_list.adapter = articleAdapter
                observe(readHistoryViewModel.readHistoryLiveData) {
                    //todo 这里要延时，要不recyclerview 不展示
                    Handler().postDelayed({
                        articleAdapter.setNewInstance(it?.articles)
                    }, 100)
                }
            }
        }

    }

    inner class OnClick {

        fun login() {
            go(ARouterPath.login)
        }
    }

}