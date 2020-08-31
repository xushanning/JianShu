package com.xu.module.wan.bean

import com.squareup.moshi.JsonClass
import com.xu.commonlib.http.BaseRes

@JsonClass(generateAdapter = true)
data class BaseResBean<T>(var errorCode: Int, var errorMsg: String, var data: T) : BaseRes<T>() {
    override fun isSuccess() = errorCode == 0

    override fun getResData() = data

    override fun getResCode() = errorCode

    override fun getResMsg() = errorMsg
}