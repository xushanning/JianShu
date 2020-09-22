package com.xu.module.wan.bean

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RankItemBean(
    val coinCount: Int,
    val level: Int,
    val rank: String,
    val userId: Int,
    val username: String
)