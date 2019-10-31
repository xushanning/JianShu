package com.xu.module.video.ui.fragment.downloading

import com.xu.commonlib.mvp.IModel
import com.xu.commonlib.mvp.IPresenter
import com.xu.commonlib.mvp.IView

/**
 * @author 言吾許
 */
interface IDownloadingContract {

    interface IDownloadingView : IView {

    }

    interface IDownloadingPresenter : IPresenter<IDownloadingView> {

    }

    interface IDownloadingModel : IModel {

    }
}