package com.xu.module.jianshu.ui.coroutine

import com.xu.commonlib.mvp.IModel
import com.xu.commonlib.mvp.IPresenter
import com.xu.commonlib.mvp.IView

interface ICoroutineContract {

    interface ICoroutineView : IView {

    }

    interface ICoroutinePresenter : IPresenter<ICoroutineView> {

    }

    interface ICoroutineModel : IModel {

    }
}