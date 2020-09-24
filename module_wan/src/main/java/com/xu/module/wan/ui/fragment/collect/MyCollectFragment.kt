package com.xu.module.wan.ui.fragment.collect

import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.orhanobut.logger.Logger
import com.xu.commonlib.utlis.extention.observe
import com.xu.module.wan.R
import com.xu.module.wan.base.BaseFragment
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WIncludeListBinding
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
class MyCollectFragment(override val layoutId: Int = R.layout.w_include_list, override val variableId: Int = -1) :
    BaseFragment<MyCollectViewModel, WIncludeListBinding>() {
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


    override fun initView(mDataBinding: WIncludeListBinding) {
        rv_list.run {
            layoutManager = LinearLayoutManager(context)
            adapter = collectArticleAdapter
            initFloatButton(float_bt)
        }
    }

    override fun initData() {
        when (type) {
            0 -> {
                observe(collectArticleAdapter, collectViewModel.myCollectArticleLiveData)
            }
            1 -> {

            }
            2 -> {
//                observe()
            }
        }
        if (type == 0) {

        } else if (type == 1) {

        }
    }

}