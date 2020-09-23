package com.xu.module.wan.db.converter

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

/**
 * 搜索历史converter
 * 其实就是string to list
 */
class SearchHistoryConverter {
    private val type = Types.newParameterizedType(MutableList::class.java, String::class.java)
    private val adapter = Moshi.Builder().build().adapter<MutableList<String>>(type)


    @TypeConverter
    fun beanToJson(bean: MutableList<String>): String {
        return adapter.toJson(bean)
    }

    @TypeConverter
    fun jsonToBean(json: String): MutableList<String>? {
        return adapter.fromJson(json)
    }

}