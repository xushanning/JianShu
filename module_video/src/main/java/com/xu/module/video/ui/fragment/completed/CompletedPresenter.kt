package com.xu.module.video.ui.fragment.completed

import com.xu.commonlib.mvp.BasePresenter
import javax.inject.Inject

/**
 * @author 言吾許
 */
class CompletedPresenter @Inject constructor() :
    BasePresenter<ICompletedContract.ICompletedView, ICompletedContract.ICompletedModel>(),
    ICompletedContract.ICompletedPresenter {

}