package com.xu.module.wan.ui.activity.web

import android.widget.LinearLayout
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.just.agentweb.AgentWeb
import com.xu.commonlib.base.mvvm.BaseVmActivity
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WAcitivityWebBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.w_acitivity_web.*

/**
 * 加载WebView
 */
@Route(path = ARouterPath.web)
@AndroidEntryPoint
class WebActivity(
    override val layoutId: Int = R.layout.w_acitivity_web,
    override val variableId: Int = BR.vm
) : BaseVmActivity<WebViewModel, WAcitivityWebBinding>() {

    @Autowired(name = "url")
    @JvmField
    var url: String? = null

    private lateinit var web: AgentWeb

    override fun initView(mDataBinding: WAcitivityWebBinding) {
        initWeb()
    }

    override fun initData() {

    }

    private fun initWeb() {
        web = AgentWeb.with(this)
            .setAgentWebParent(ll_container, LinearLayout.LayoutParams(-1, -1))
            .useDefaultIndicator()
            .createAgentWeb()
            .ready()
            .go(url)
    }
}