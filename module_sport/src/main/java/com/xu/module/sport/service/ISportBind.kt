package com.xu.module.sport.service

/**
 * @author 言吾許
 */
interface ISportBind {
    /**
     * 开始运动
     */
    fun startSport()

    /**
     * 结束运动
     */
    fun stopSport()

    /**
     * 继续运动
     */
    fun continueSport()

    /**
     * 删除过短的轨迹
     */
    fun deleteTooShortTrajectory()

    /**
     * 获取service实例
     */
    fun getSportService(): SportService
}