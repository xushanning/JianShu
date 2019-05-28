package com.xu.module.sport.ui.activity.main

import com.orhanobut.logger.Logger
import com.xu.commonlib.mvp.BasePresenter
import javax.inject.Inject

/**
 * @author 言吾許
 */
class MainPresenter @Inject constructor() : BasePresenter<IMainContract.IMainView, IMainContract.IMainModel>(),
    IMainContract.IMainPresenter {
    override fun setModel(): IMainContract.IMainModel {
        return MainModel()
    }

    override fun sayHello() {
        Logger.d("hello")
    }
}