package com.xu.module.wan.bean

import com.squareup.moshi.JsonClass

/**
 * 个人中心功能bean
 */
@JsonClass(generateAdapter = true)
data class CommonUseBean(
    val name: String,
    val path: String,
    val resource: String
)