package com.xu.module.wan.ui.fragment.project

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.tabs.TabLayoutMediator
import com.xu.commonlib.utlis.extention.getFragment
import com.xu.commonlib.utlis.extention.observe
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.base.BaseFragment
import com.xu.module.wan.bean.ProjectBean
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WFragmentProjectBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.w_fragment_project.*

/**
 * 广场fragment
 */
@Route(path = ARouterPath.project)
@AndroidEntryPoint
class ProjectFragment(
    override val layoutId: Int = R.layout.w_fragment_project,
    override val variableId: Int = BR.vm
) : BaseFragment<ProjectViewModel, WFragmentProjectBinding>() {
    override fun initView(mDataBinding: WFragmentProjectBinding) {

    }

    override fun initData() {
        mViewModel.getProjectType()
        observe(mViewModel.typeLiveData) {
            //添加最新的项目
            it.add(0, ProjectBean(name = "最新项目"))
            vp_project.adapter = object : FragmentStateAdapter(this) {

                override fun getItemCount(): Int {
                    return it.size
                }


                override fun createFragment(position: Int): Fragment {
                    return getFragment(ARouterPath.projectList) {
                        withInt("id", it[position].id)
                    }
                }
            }
            //联动
            TabLayoutMediator(tl_project, vp_project) { tab, position ->
                tab.text = it[position].name
            }.attach()
        }
    }
}