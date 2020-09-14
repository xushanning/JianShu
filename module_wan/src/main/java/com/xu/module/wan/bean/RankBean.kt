package com.xu.module.wan.bean

import com.squareup.moshi.JsonClass

/**
 * @author 许 on 2020/9/14.
 */
@JsonClass(generateAdapter = true)
data class RankBean(
    /**
     * 总积分
     */
    val coinCount: Int,
    /**
     * 总积分
     */
    val rank: Int,
    val userId: Int,
    val username: String
)