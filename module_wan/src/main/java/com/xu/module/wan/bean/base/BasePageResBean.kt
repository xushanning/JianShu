package com.xu.module.wan.bean.base

import com.squareup.moshi.JsonClass

/**
 * 带有分页的bean
 */
@JsonClass(generateAdapter = true)
data class BasePageResBean<T>(
    val curPage: Int,
    val datas: T,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)
