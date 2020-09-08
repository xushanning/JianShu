package com.xu.module.wan.ui.fragment.projectlist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.utlis.extention.request
import com.xu.module.wan.api.WanService
import com.xu.module.wan.bean.ArticleItemBean
import com.xu.module.wan.bean.base.BasePageResBean
import com.xu.module.wan.bean.base.BaseResBean

class ProjectListViewModel @ViewModelInject constructor(
    private val api: WanService
) : BaseViewModel() {

    val projectList = MutableLiveData<MutableList<ArticleItemBean>>()

    fun getArticleListByType(typeId: Int) {
        request({ getData(typeId) }, {
            projectList.postValue(it.datas)
        }, {

        })
    }

    private suspend fun getData(typeId: Int): BaseResBean<BasePageResBean<MutableList<ArticleItemBean>>> {
        return if (typeId == -1) {
            api.getLatestProjectList(0)
        } else {
            api.getProjectListByType(0, typeId)
        }
    }
}