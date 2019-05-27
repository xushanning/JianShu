package com.xu.module.sport.ui.activity.main

import com.xu.commonlib.mvp.BasePresenter

/**
 * @author 言吾許
 */
class MainPresenter : BasePresenter<IMainContract.IMainView, IMainContract.IMainModel>(), IMainContract.IMainPresenter {
    override fun setModel(): IMainContract.IMainModel {
        return MainModel()
    }

}