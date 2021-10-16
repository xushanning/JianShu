package com.xu.module.wan.ui.activity.integral

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.utlis.extention.navigate
import com.xu.commonlib.utlis.extention.observe
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.api.WanService
import com.xu.module.wan.base.BaseActivity
import com.xu.module.wan.bean.RankItemBean
import com.xu.module.wan.bean.RankRecordBean
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WActivityIntegralBinding
import com.xu.module.wan.databinding.WItemIntegralBinding
import com.xu.module.wan.databinding.WItemIntegralRecordBinding
import com.xu.module.wan.utils.ext.createPageBindingAdapter
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

    companion object {
        /**
         * rank榜
         */
        const val INTEGRAL_TYPE_RANK = 1

        /**
         * 记录
         */
        const val INTEGRAL_TYPE_RECORD = 2

    }

    @Autowired(name = "type")
    @JvmField
    var type: Int = 1

    @Inject
    lateinit var api: WanService

    /**
     * 积分排行和获取积分记录共用一个recyclerview
     * 正好验证adapter设计模式是剥离业务逻辑
     */

    private val rankAdapter = createPageBindingAdapter<RankItemBean, WItemIntegralBinding>(
        R.layout.w_item_integral,
        { oldItem, newItem ->
            oldItem.rank == newItem.rank
        },
        { oldItem, newItem ->
            oldItem.rank == newItem.rank
        },
        { holder, item ->
            holder.dataBinding?.item = item
        })

    /**
     * 积分获取记录adapter
     */
    private val recordAdapter =
        createPageBindingAdapter<RankRecordBean, WItemIntegralRecordBinding>(
            R.layout.w_item_integral_record,
            { oldItem, newItem ->
                oldItem.id == newItem.id
            },
            { oldItem, newItem ->
                oldItem.id == newItem.id
            },
            { holder, item ->
                holder.dataBinding?.item = item
            })


    override fun initView(mDataBinding: WActivityIntegralBinding) {
        mDataBinding.click = OnClick()

        when (type) {
            INTEGRAL_TYPE_RANK -> {
                observe(rankAdapter, mViewModel.getIntegralRank())
                mViewModel.titleLiveData.postValue(getString(R.string.w_integral_title))
                mViewModel.rankVisibleLiveData.postValue(View.VISIBLE)
                rv_list.adapter = rankAdapter
            }
            INTEGRAL_TYPE_RECORD -> {
                observe(recordAdapter, mViewModel.getIntegralRecord())
                //如果不担心内存泄漏或者其他问题，可以这么干，但是不建议
                //observer(recordAdapter) { api.getRankRecord(it + 1) }
                mViewModel.titleLiveData.postValue(getString(R.string.w_integral_record))
                mViewModel.rankVisibleLiveData.postValue(View.GONE)
                rv_list.adapter = recordAdapter
            }
        }
    }

    override fun initData() {
        mViewModel.getRank()
        rv_list.run {
            layoutManager = LinearLayoutManager(this@IntegralActivity)
            initFloatButton(float_bt)
        }
    }

    override fun useLightMode(): Boolean {
        return true
    }

    inner class OnClick {
        fun onBack() {
            finish()
        }

        fun record() {
            navigate(ARouterPath.integral) {
                withInt("type", INTEGRAL_TYPE_RECORD)
            }
        }

        fun question() {
            navigate(ARouterPath.web) {
                withString("url", "https://www.wanandroid.com/blog/show/2653")
                withString("title", "本站积分规则")
            }
        }
    }
}