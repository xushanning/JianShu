package com.xu.module.wan.ui.fragment.navigation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.utlis.extention.request
import com.xu.module.wan.api.WanService
import com.xu.module.wan.bean.NavigationBean
import com.xu.module.wan.bean.NavigationWrapBean

/**
 * @author 许 on 2020/9/21.
 */
class NavigationViewModel @ViewModelInject constructor(
    private val api: WanService
) : BaseViewModel() {
    val navigationLiveData by lazy { MutableLiveData<MutableList<NavigationBean>>() }

    val rightLiveData by lazy { MutableLiveData<MutableList<NavigationWrapBean>>() }

    fun getNavigationData() {
        request({ api.getNavigationData() }, {
            navigationLiveData.postValue(it)
            val rightData = ArrayList<NavigationWrapBean>()
            it.forEach { item ->
                val titleBean = NavigationWrapBean(item, null)
                rightData.add(titleBean)
                item.articles.forEach { article ->
                    val contentBean = NavigationWrapBean(null, article)
                    rightData.add(contentBean)
                }
            }
            rightLiveData.postValue(rightData)
        }, {
            Logger.d(it.message)
        })
    }
}