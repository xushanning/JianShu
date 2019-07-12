package com.xu.module.sport.ui.activity.historylist

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.xu.commonlib.db.entity.TrajectoryEntity
import com.xu.module.sport.beans.HistoryHeadBean

/**
 * @author 言吾許
 * 历史记录的item包装bean，包含了两种：一种head  一种item
 */
class HistoryBean constructor(type: Int, var trajectoryEntity: TrajectoryEntity, var headBean: HistoryHeadBean) :
    MultiItemEntity {
    private var itemType: Int = type

    override fun getItemType(): Int {
        return itemType
    }
}