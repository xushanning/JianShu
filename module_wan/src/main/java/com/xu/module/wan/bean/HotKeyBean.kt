package com.xu.module.wan.bean

import com.squareup.moshi.JsonClass

/**
 * @author 许 on 2020/9/20.
 * 搜索热词
 */
@JsonClass(generateAdapter = true)
data class HotKeyBean(
    val id: Int,
    val link: String,
    val name: String,
    val order: Int,
    val visible: Int
)