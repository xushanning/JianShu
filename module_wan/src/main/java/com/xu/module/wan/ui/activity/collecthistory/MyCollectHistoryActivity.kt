package com.xu.module.wan.ui.activity.collecthistory

import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.utlis.extention.getFragment
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.base.BaseActivity
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WActivityCollectHistoryBinding
import com.xu.module.wan.utils.ext.init
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.w_activity_collect_history.*

/**
 * 包含了收藏文章、收藏网站、浏览历史的activity
 */
@Route(path = ARouterPath.myCollectHistory)
@AndroidEntryPoint
class MyCollectHistoryActivity(override val layoutId: Int = R.layout.w_activity_collect_history, override val variableId: Int = BR.vm) :
    BaseActivity<MyCollectHistoryViewModel, WActivityCollectHistoryBinding>() {
    /**
     * 类型：
     * 0：收藏
     * 1：浏览历史
     */
    @Autowired(name = "type")
    @JvmField
    var type: Int? = 0

    override fun initView(mDataBinding: WActivityCollectHistoryBinding) {
        mDataBinding.click = OnClick()

        val tabNames = listOf("文章", "网站", "浏览历史")
        val fragments = listOf(
            getFragment(ARouterPath.myCollect) {
                withInt(
                    "type",
                    0
                )
            },
            getFragment(ARouterPath.myCollect) {
                withInt(
                    "type", 1
                )
            },
            getFragment(ARouterPath.myCollect)
        )
        vp_collect.init(this,tl_collect,fragments,tabNames)
    }

    override fun initData() {

    }

    override fun useLightMode(): Boolean {
        return true
    }
    inner class OnClick {
        fun onBackClick() {
            finish()
        }
    }
}