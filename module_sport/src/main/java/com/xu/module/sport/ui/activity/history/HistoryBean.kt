package com.xu.module.sport.ui.activity.history

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.xu.commonlib.db.entity.TrajectoryEntity

/**
 * @author 言吾許
 */
class HistoryBean constructor(type: Int, trajectoryEntity: TrajectoryEntity) : MultiItemEntity {
    private var itemType: Int = type
    private var trajectoryEntity: TrajectoryEntity = trajectoryEntity

    override fun getItemType(): Int {
        return itemType
    }
}