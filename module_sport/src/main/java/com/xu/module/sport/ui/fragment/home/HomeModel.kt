package com.xu.module.sport.ui.fragment.home

import com.xu.commonlib.db.entity.TrajectoryEntity
import com.xu.commonlib.mvp.BaseModel
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * @author 言吾許
 */
class HomeModel @Inject constructor() : BaseModel(), IHomeContract.IHomeModel {
    override fun getCurrentMonthSportStatistics(sportType: Int, year: Int, month: Int): Flowable<List<TrajectoryEntity>> {
        return sportDao.queryCurrentMonthHistoryByType(sportType, year, month)
    }

    override fun getAllSportTotalMileage(): Flowable<List<TrajectoryEntity>> {
        return sportDao.queryAllHistory()
    }
}