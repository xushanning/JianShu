package com.xu.module.sport.ui.activity.historydetail

import com.orhanobut.logger.Logger
import com.xu.commonlib.mvp.BasePresenter
import com.xu.commonlib.utlis.TransformUtil
import javax.inject.Inject

/**
 * @author 言吾許
 */
class HistoryDetailPresenter @Inject constructor() :
    BasePresenter<IHistoryDetailContract.IHistoryDetailView, IHistoryDetailContract.IHistoryDetailModel>(),
    IHistoryDetailContract.IHistoryDetailPresenter {
    override fun getDetailById(trajectoryId: String) {
        val historyDis = mModel.getDetailById(trajectoryId)
            .compose(TransformUtil.defaultFlowableSchedulers())
            .compose(mView.bindToLife())
            .subscribe({
                mView.loadDetail(it)
            }, { Logger.d(it.message) })
        mCompositeDisposable.add(historyDis)
    }
}