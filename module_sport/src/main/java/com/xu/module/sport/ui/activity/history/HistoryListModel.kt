package com.xu.module.sport.ui.activity.history

import com.orhanobut.logger.Logger
import com.xu.commonlib.db.entity.TrajectoryEntity
import com.xu.commonlib.mvp.BaseModel
import io.reactivex.Flowable
import java.time.Month
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
        Logger.d("查询的年月$year+$month")
        return sportDao.queryHistoryByMonth(year, month)
    }
}