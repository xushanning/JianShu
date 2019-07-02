package com.xu.module.sport.bean

/**
 * @author 许 on 2019/7/2.
 * 轨迹bean
 */
data class TrajectoryBean(
    /**
     * 轨迹id
     */
    val trajectoryId: Int,
    /**
     * 运动时间
     */
    val sportTime: Long,
    /**
     * 运动的里程
     */
    val sportMileage: Long
)