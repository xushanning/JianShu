package com.xu.module.wan.ui.fragment.projectlist

import androidx.hilt.lifecycle.ViewModelInject
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.module.wan.api.WanService
import com.xu.module.wan.utils.ext.createPager


class ProjectListViewModel @ViewModelInject constructor(
    private val api: WanService
) : BaseViewModel() {
    /**
     * 分页数据 liveData
     */
    fun pager(typeId: Int) = createPager {
        if (typeId == -1) {
            api.getLatestProjectList(it)
        } else {
            api.getProjectListByType(it, typeId)
        }
    }
}