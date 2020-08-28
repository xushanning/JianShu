package com.xu.module.jianshu.ui.coroutine

import com.xu.commonlib.mvp.BasePresenter
import com.xu.module.jianshu.api.WanService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CoroutinePresenter @Inject constructor() :
    BasePresenter<ICoroutineContract.ICoroutineView, ICoroutineContract.ICoroutineModel>(),
    ICoroutineContract.ICoroutinePresenter {


    @Inject
    lateinit var api: WanService

    override fun getData() {
        lifecycleScope.launch(Dispatchers.IO) {
            val result = api.getArticleList()
            var name = ""
            result.data.forEach {
                name += it.name
            }
            withContext(Dispatchers.Main) {
                mView.loadData(name)
            }
        }
    }
}