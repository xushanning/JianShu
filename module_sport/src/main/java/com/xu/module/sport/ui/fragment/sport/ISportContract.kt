package com.xu.module.sport.ui.fragment.sport

import com.xu.commonlib.mvp.IModel
import com.xu.commonlib.mvp.IPresenter
import com.xu.commonlib.mvp.IView

/**
 * @author 言吾許
 */
interface ISportContract {
    interface ISportView : IView {

    }

    interface ISportPresenter : IPresenter<ISportView> {

    }

    interface ISportModel : IModel {

    }
}