package com.xu.module.sport.ui.activity.main

import com.xu.commonlib.mvp.IModel
import com.xu.commonlib.mvp.IPresenter
import com.xu.commonlib.mvp.IView

/**
 * @author 言吾許
 */
interface IMainContract {
    interface IMainView : IView {

    }

    interface IMainPresenter : IPresenter<IMainView> {

    }

    interface IMainModel : IModel {

    }
}