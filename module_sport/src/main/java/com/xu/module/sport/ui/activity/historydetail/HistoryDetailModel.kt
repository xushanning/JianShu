package com.xu.module.sport.ui.activity.historydetail

import com.xu.commonlib.db.entity.TrajectoryEntity
import com.xu.commonlib.mvp.BaseModel
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * @author 言吾許
 */
class HistoryDetailModel @Inject constructor() : BaseModel(), IHistoryDetailContract.IHistoryDetailModel {
    override fun getDetailById(trajectoryId: String): Flowable<TrajectoryEntity> {
        return sportDao.queryHistoryById(trajectoryId)
    }

}