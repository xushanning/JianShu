package com.xu.module.wan.ui.fragment.project

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.utlis.extention.request
import com.xu.module.wan.api.WanService
import com.xu.module.wan.bean.ProjectBean

class ProjectViewModel @ViewModelInject constructor(
    private val api: WanService
) : BaseViewModel() {
    val typeLiveData = MutableLiveData<MutableList<ProjectBean>>()

    fun getProjectType() {
        request({ api.getProjectType() }, typeLiveData, {

        })
    }
}