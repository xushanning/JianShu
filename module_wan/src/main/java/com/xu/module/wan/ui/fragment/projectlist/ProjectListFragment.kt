package com.xu.module.wan.ui.fragment.projectlist

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.utlis.extention.navigate
import com.xu.commonlib.utlis.extention.observe
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.base.BaseFragment
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WFragmentProjectListBinding
import com.xu.module.wan.ui.fragment.home.ArticlePagingAdapter
import com.xu.module.wan.viewmodel.ArticleCollectViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.w_fragment_project_list.*
import javax.inject.Inject

/**
 * 项目列表fragment
 */
@Route(path = ARouterPath.projectList)
@AndroidEntryPoint
class ProjectListFragment(
    override val layoutId: Int = R.layout.w_fragment_project_list,
    override val variableId: Int = BR.vm
) : BaseFragment<ProjectListViewModel, WFragmentProjectListBinding>() {

    @Autowired(name = "id")
    @JvmField
    var id: Int? = 0


    @Inject
    lateinit var pagingAdapter: ArticlePagingAdapter

    private val collectViewModel: ArticleCollectViewModel by viewModels()


    override fun initView(mDataBinding: WFragmentProjectListBinding) {

        rv_project_list.run {
            layoutManager = LinearLayoutManager(context)
            adapter = pagingAdapter
        }
        pagingAdapter.run {
            setOnItemClickListener { item, _ ->
                navigate(ARouterPath.web) {
                    withString("url", item.link)
                    withString("title", item.title)
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
    }

    override fun initData() {
        observe(pagingAdapter, mViewModel.pager(id!!))
    }
}