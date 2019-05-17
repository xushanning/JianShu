package com.xu.module.jianshu.ui.home

import com.xu.commonlib.mvp.IBaseMvpView
import com.xu.commonlib.mvp.IBasePresenter

/**
 * @author 言吾許
 */
interface IHomeContract {
    interface IHomeView : IBaseMvpView {

    }

    interface IHomePresenter : IBasePresenter<IHomeView> {

    }
}