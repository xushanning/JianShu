package com.xu.module.jianshu.ui.coroutine

import com.xu.commonlib.mvp.BasePresenter
import javax.inject.Inject

class CoroutinePresenter @Inject constructor() :
    BasePresenter<ICoroutineContract.ICoroutineView, ICoroutineContract.ICoroutineModel>(),
    ICoroutineContract.ICoroutinePresenter {

}