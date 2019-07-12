package com.xu.module.sport.ui.activity.historylist

import com.xu.commonlib.db.entity.TrajectoryEntity
import com.xu.commonlib.mvp.BaseModel
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * @author 言吾許
 */
class HistoryListModel @Inject constructor() : BaseModel(), IHistoryListContract.IHistoryListModel {
    override fun getSportYear(): Flowable<List<TrajectoryEntity>> {
        return sportDao.queryAllHistory()
    }

    override fun getSportMonthByYear(year: Int): Flowable<List<TrajectoryEntity>> {
        return sportDao.queryHistoryByYear(year)
    }

    override fun getSportHistoryByMonth(year: Int, month: Int): Flowable<List<TrajectoryEntity>> {
        return sportDao.queryHistoryByMonth(year, month)
    }
}