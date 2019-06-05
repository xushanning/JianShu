package com.xu.module.sport.ui.fragment.home

import com.xu.commonlib.mvp.IModel
import com.xu.commonlib.mvp.IPresenter
import com.xu.commonlib.mvp.IView


/**
 * @author 言吾許
 */
interface IHomeContract {
    interface IHomeView : IView {

    }

    interface IHomePresenter : IPresenter<IHomeView> {}

    interface IHomeModel : IModel {

    }
}