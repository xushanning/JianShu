package com.xu.module.wan.ui.fragment.projectlist

import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.mvvm.BaseVmFragment
import com.xu.commonlib.utlis.extention.go
import com.xu.commonlib.utlis.extention.observe
import com.xu.commonlib.utlis.extention.singleChildDataItemClick
import com.xu.commonlib.utlis.extention.singleDataItemClick
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WFragmentProjectListBinding
import com.xu.module.wan.ui.fragment.home.HomeArticleItemQuickAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.w_fragment_project_list.*

/**
 * 项目列表fragment
 */
@Route(path = ARouterPath.projectList)
@AndroidEntryPoint
class ProjectListFragment(
    override val layoutId: Int = R.layout.w_fragment_project_list,
    override val variableId: Int = BR.vm
) : BaseVmFragment<ProjectListViewModel, WFragmentProjectListBinding>() {

    @Autowired(name = "id")
    @JvmField
    var id: Int? = null

    private val quickAdapter: HomeArticleItemQuickAdapter by lazy { HomeArticleItemQuickAdapter() }


    override fun initView(mDataBinding: WFragmentProjectListBinding) {

        rv_project_list.run {
            layoutManager = LinearLayoutManager(context)
            adapter = quickAdapter
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
        mViewModel.getArticleListByType(id!!)
        observe(mViewModel.projectList) {
            quickAdapter.setNewInstance(it)
        }
    }
}