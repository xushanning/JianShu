package com.xu.module.wan.ui.activity.integral

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.utlis.extention.request
import com.xu.module.wan.api.WanService
import com.xu.module.wan.bean.RankBean
import com.xu.module.wan.utils.ext.createPager

class IntegralViewModel @ViewModelInject constructor(
    private val api: WanService
) : BaseViewModel() {

    /**
     * 排名+积分
     */
    val rankLiveData = MutableLiveData<RankBean>()

    /**
     * title
     */
    val titleLiveData = MutableLiveData<String>()

    /**
     * rank独有的ui可见性
     */
    val rankVisibleLiveData = MutableLiveData<Int>()

    /**
     * rank 列表 paging
     */
    fun getIntegralRank() = createPager {
        api.getRankList(it + 1)
    }

    /**
     * 积分获取的记录
     */
    fun getIntegralRecord() = createPager {
        api.getRankRecord(it + 1)
    }

    fun getRank() {
        request({
            api.getRank()
        }, rankLiveData, {

        }, true)
    }
}