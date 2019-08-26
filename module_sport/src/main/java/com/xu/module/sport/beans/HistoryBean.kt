package com.xu.module.sport.beans

import com.xu.commonlib.db.entity.TrajectoryEntity
import com.xu.module.sport.ui.activity.historylist.HistoryItemEntity

/**
 * @author 言吾許
 */
data class HistoryBean(
    /**
     * 类型
     */
    val itemType: Int,
    /**
     * 头部数据bean
     */
    val headBean: HistoryHeadBean,
    /**
     * item数据bean
     */
    val dataBean: TrajectoryEntity
)