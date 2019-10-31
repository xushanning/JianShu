package com.xu.module.video.ui.fragment.downloading

import com.xu.commonlib.mvp.BasePresenter
import javax.inject.Inject

/**
 * @author 言吾許
 */
class DownloadingPresenter @Inject constructor() :
    BasePresenter<IDownloadingContract.IDownloadingView, IDownloadingContract.IDownloadingModel>(),
    IDownloadingContract.IDownloadingPresenter {
}