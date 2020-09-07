package com.xu.module.wan.ui.fragment.projectlist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.utlis.extention.request
import com.xu.module.wan.api.WanService
import com.xu.module.wan.bean.ArticleItemBean

class ProjectListViewModel @ViewModelInject constructor(
    private val api: WanService
) : BaseViewModel() {

    val projectList = MutableLiveData<MutableList<ArticleItemBean>>()

    fun getArticleListByType(typeId: Int) {
        request({ api.getProjectListByType(1, typeId) }, {

        }, {

        })
    }
}