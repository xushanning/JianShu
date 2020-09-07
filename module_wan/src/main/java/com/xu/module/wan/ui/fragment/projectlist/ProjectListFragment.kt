package com.xu.module.wan.ui.fragment.projectlist

import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.mvvm.BaseVmFragment
import com.xu.commonlib.utlis.extention.observe
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WFragmentProjectListBinding
import dagger.hilt.android.AndroidEntryPoint

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


    override fun initView(mDataBinding: WFragmentProjectListBinding) {

    }

    override fun initData() {
        mViewModel.getArticleListByType(id!!)
        observe(mViewModel.projectList) {

        }
    }
}