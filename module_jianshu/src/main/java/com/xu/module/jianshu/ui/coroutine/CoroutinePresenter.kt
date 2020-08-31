package com.xu.module.jianshu.ui.coroutine

import com.xu.commonlib.mvp.BasePresenter
import javax.inject.Inject

class CoroutinePresenter @Inject constructor() :
    BasePresenter<ICoroutineContract.ICoroutineView, ICoroutineContract.ICoroutineModel>(),
    ICoroutineContract.ICoroutinePresenter {


    override fun getData() {
//        MainScope().launch(Dispatchers.IO) {
//            val result = api.getArticleList()
//            var name = ""
//            result.data.forEach {
//                name += it.name
//            }
//            withContext(Dispatchers.Main) {
//                mView.loadData(name)
//            }
//        }
    }
}