package com.xu.module.video.ui.activity.main

import com.orhanobut.logger.Logger
import com.xu.commonlib.mvp.BasePresenter
import com.xu.commonlib.utlis.TransformUtil
import javax.inject.Inject

/**
 * @author 言吾許
 */
class MainPresenter @Inject constructor() :
    BasePresenter<IMainContract.IMainView, IMainContract.IMainModel>(),
    IMainContract.IMainPresenter {
    override fun getShareHtml(shareUrl: String) {
        val htmlDis = mModel.getShareHtml(shareUrl)
            .compose(mView.bindToLife())
            .compose(TransformUtil.defaultSchedulers())
            .subscribe({ Logger.d(it) }, { Logger.d(it.message) })

        mCompositeDisposable.add(htmlDis)

    }

}