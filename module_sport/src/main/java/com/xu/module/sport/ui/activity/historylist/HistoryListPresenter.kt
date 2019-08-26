package com.xu.module.sport.ui.activity.historylist

import com.orhanobut.logger.Logger
import com.xu.commonlib.mvp.BasePresenter
import com.xu.commonlib.utlis.TransformUtil
import com.xu.module.sport.util.ApiException
import javax.inject.Inject

/**
 * @author 言吾許
 */
class HistoryListPresenter @Inject constructor() :
    BasePresenter<IHistoryListContract.IHistoryListView, IHistoryListContract.IHistoryListModel>(),
    IHistoryListContract.IHistoryListPresenter {

    override fun getSportYear() {
        val yearDis = mModel.getSportYear()
            .map {
                val yearList = ArrayList<Int>()
                it.forEach { entity ->
                    yearList.add(entity.year!!)
                }
                //去重 排序
                val resultList = yearList.distinct().sorted()
                if (resultList.isEmpty()) {
                    throw ApiException("没有运动记录")
                } else {
                    resultList
                }
            }
            .compose(TransformUtil.defaultFlowableSchedulers())
            .compose(mView.bindToLife())
            .subscribe({ mView.loadSportYear(it) }, { Logger.d(it.message) })


        mCompositeDisposable.add(yearDis)

    }


    override fun getSportMonthByYear(year: Int) {
        val monthDis = mModel.getSportMonthByYear(year)
            .map {
                val monthList = ArrayList<Int>()
                it.forEach { entity ->
                    monthList.add(entity.month!!)
                }
                monthList.distinct().sorted()
            }
            .compose(TransformUtil.defaultFlowableSchedulers())
            .compose(mView.bindToLife())
            .subscribe({
                Logger.d("点击的年份的时候加载")
                mView.loadSportMonth(it)
            }, { Logger.d(it.message) })
        mCompositeDisposable.add(monthDis)
    }


    override fun getSportHistoryByMonth(year: Int, month: Int) {
        val monthDis = mModel.getSportHistoryByMonth(year, month)
            .map {
                val data = ArrayList<HistoryItemEntity>()
                it.forEach { item ->
                    val entity = HistoryItemEntity(HistoryListAdapter.TYPE_DATA, item, null)
                    data.add(entity)
                }
                data
            }
            .compose(TransformUtil.defaultFlowableSchedulers())
            .compose(mView.bindToLife())
            .subscribe({ mView.loadSportHistoryList(it) }, { Logger.d(it.message) })
        mCompositeDisposable.add(monthDis)
    }
}