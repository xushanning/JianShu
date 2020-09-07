package com.xu.module.wan.bean

import com.squareup.moshi.JsonClass

/**
 * 首页banner bean
 */
@JsonClass(generateAdapter = true)
data class BannerBean(
    val desc: String,
    val id: Int,
    val imagePath: String,
    val isVisible: Int,
    val order: Int,
    val title: String,
    val type: Int,
    val url: String
)