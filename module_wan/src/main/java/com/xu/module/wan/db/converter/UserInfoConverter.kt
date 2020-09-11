package com.xu.module.wan.db.converter

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.xu.module.wan.bean.UserInfoBean

class UserInfoConverter {
    private val adapter = Moshi.Builder().build().adapter(UserInfoBean::class.java)

    @TypeConverter
    fun beanToJson(bean: UserInfoBean): String {
        return adapter.toJson(bean)
    }

    @TypeConverter
    fun jsonToBean(json: String): UserInfoBean? {
        return adapter.fromJson(json)
    }
}