package com.xu.module.wan.bean

import com.squareup.moshi.JsonClass

/**
 * 积分获取记录bean
 */
@JsonClass(generateAdapter = true)
data class RankRecordBean(
    val coinCount: Int,
    val date: Long,
    val desc: String,
    val id: Int,
    /**
     * 获取方式
     */
    val reason: String,
    val type: Int,
    val userId: Int,
    val userName: String
)