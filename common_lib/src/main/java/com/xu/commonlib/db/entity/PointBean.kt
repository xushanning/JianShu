package com.xu.commonlib.db.entity

/**
 * @author 言吾許
 */
data class PointBean(
    val latitude: Double,
    val longitude: Double,
    val altitude: Double,
    /**
     * 定位点位时候的时间戳
     */
    val time: Long
)