package com.xu.module.wan.ui.fragment.knowledgesystem

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.utlis.extention.request
import com.xu.module.wan.api.WanService
import com.xu.module.wan.bean.KnowledgeSystemBean

class KnowledgeSystemViewModel @ViewModelInject constructor(
    private val api: WanService
) : BaseViewModel() {

    val knowledgeLiveData = MutableLiveData<MutableList<KnowledgeSystemBean>>()


    fun getKnowledgeData() {
        request({ api.getKnowledgeSystemData() },
            knowledgeLiveData, {
                Logger.d(it.message)
            })
    }
}