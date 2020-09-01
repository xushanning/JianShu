package com.xu.module.wan.bean

/**
 * 带有分页的bean
 */
data class BasePageResBean<T>(
    val curPage: Int,
    val datas: T,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)
