package com.xu.module.wan.ui.fragment.knowledgesystem

import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.flexbox.FlexboxLayoutManager
import com.orhanobut.logger.Logger
import com.xu.commonlib.utlis.extention.observe
import com.xu.commonlib.utlis.extention.singleChildDataItemClick
import com.xu.commonlib.utlis.extention.singleChildItemClick
import com.xu.module.wan.R
import com.xu.module.wan.base.BaseFragment
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WIncludeListBinding
import com.xu.module.wan.utils.ext.initFloatButton
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.w_include_list.*
import javax.inject.Inject

/**
 * 知识体系fragment
 */
@Route(path = ARouterPath.knowledgeSystem)
@AndroidEntryPoint
class KnowledgeSystemFragment(override val layoutId: Int = R.layout.w_include_list, override val variableId: Int = -1) :
    BaseFragment<KnowledgeSystemViewModel, WIncludeListBinding>() {

    @Inject
    lateinit var knowledgeAdapter: KnowledgeSystemAdapter

    override fun initView(mDataBinding: WIncludeListBinding) {
        rv_list.run {
            setItemViewCacheSize(200)
            setHasFixedSize(true)
            adapter = this@KnowledgeSystemFragment.knowledgeAdapter
            layoutManager = FlexboxLayoutManager(requireContext())
            initFloatButton(float_bt)
        }
        knowledgeAdapter.singleChildDataItemClick { item, viewId ->
            if (viewId == R.id.tv_name) {
                Logger.d(item.name)
            }
        }

        swipe_refresh.isEnabled = false
    }

    override fun initData() {
        mViewModel.getKnowledgeData()
        observe(mViewModel.knowledgeLiveData) {
            knowledgeAdapter.setNewInstance(it)
        }
    }

}