package com.xu.module.sport.ui.activity.history

import com.orhanobut.logger.Logger
import com.xu.commonlib.db.entity.TrajectoryEntity
import com.xu.commonlib.mvp.BasePresenter
import com.xu.commonlib.utlis.TransformUtil
import com.xu.module.sport.util.ApiException
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.time.Month
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
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                mView.loadSportYear(it)
                it[it.size - 1]
            }
            .observeOn(Schedulers.io())
            .flatMap { mModel.getSportMonthByYear(it) }
            .compose(TransformUtil.defaultFlowableSchedulers())
            .subscribe({

            }, { Logger.d(it.message) })

        mCompositeDisposable.add(yearDis)

    }

    //todo 上下两个部分代码重复，可以合并

    override fun getSportMonthByYear(year: Int) {
        val monthDis = mModel.getSportMonthByYear(year)
            .map {
                val monthList = ArrayList<Int>()
                it.forEach { entity ->
                    monthList.add(entity.month!!)
                }
                monthList.distinct().sorted()
            }
            .subscribe()
        mCompositeDisposable.add(monthDis)
    }

    override fun getSportHistoryByMonth(year: Int, month: Month) {
        val monthDis = mModel.getSportHistoryByMonth(year, month)
            .subscribe()
        mCompositeDisposable.add(monthDis)
    }
}