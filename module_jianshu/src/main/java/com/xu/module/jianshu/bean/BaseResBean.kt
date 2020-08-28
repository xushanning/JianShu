package com.xu.module.jianshu.bean

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BaseResBean<T>(
    val errorMsg: String,
    val errorCode: Int,
    val data: T
)