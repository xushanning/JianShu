package com.xu.module.sport.beans

/**
 * @author 言吾許
 * 历史list head info bean
 */
data class HistoryHeadBean(
    /**
     * 某个月的运动总里程
     */
    val monthMileage: String,
    /**
     * 某个月的运动总时间
     */
    val monthDuration: String,
    /**
     * 某个月的运动总次数
     */
    val monthCount: String,
    /**
     * 某个月的运动总热度
     */
    val monthHeat: String
)