package com.xu.module.wan.ui.activity.integral

import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.utlis.extention.go
import com.xu.commonlib.utlis.extention.observe
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.base.BaseActivity
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WActivityIntegralBinding
import com.xu.module.wan.utils.ext.initFloatButton
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.w_include_list.*
import javax.inject.Inject

/**
 * 积分排行+获取积分记录
 */
@Route(path = ARouterPath.integral)
@AndroidEntryPoint
class IntegralActivity(override val layoutId: Int = R.layout.w_activity_integral, override val variableId: Int = BR.vm) :
    BaseActivity<IntegralViewModel, WActivityIntegralBinding>() {

    /**
     * 积分排行和获取积分记录共用一个recyclerview
     * 正好验证adapter设计模式是剥离业务逻辑
     */
    @Inject
    lateinit var rankAdapter: IntegralAdapter

    @Inject
    lateinit var recordAdapter: IntegralRecordAdapter

    override fun initView(mDataBinding: WActivityIntegralBinding) {
        mDataBinding.click = OnClick()
    }

    override fun initData() {
        mViewModel.getRank()
        rv_list.run {
            layoutManager = LinearLayoutManager(this@IntegralActivity)
            adapter = this@IntegralActivity.rankAdapter
            initFloatButton(float_bt)
        }
        observe(rankAdapter, mViewModel.getIntegralRank())
    }

    override fun useLightMode(): Boolean {
        return true
    }

    inner class OnClick {
        fun onBack() {
            finish()
        }

        fun record() {
            go(ARouterPath.integralRecord)
        }

        fun question() {
            go(ARouterPath.web) {
                withString("url", "https://www.wanandroid.com/blog/show/2653")
                withString("title", "本站积分规则")
            }
        }
    }
}