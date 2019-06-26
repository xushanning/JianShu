package com.xu.module.sport.service

/**
 * @author 言吾許
 */
interface ISportBind {

    fun startSport()

    fun stopSport()

    fun continueSport()

    fun getSportService(): SportService
}