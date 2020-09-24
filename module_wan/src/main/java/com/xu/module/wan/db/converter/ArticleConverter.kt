package com.xu.module.wan.db.converter

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.xu.module.wan.bean.ArticleItemBean

class ArticleConverter {
    private val type =
        Types.newParameterizedType(MutableList::class.java, ArticleItemBean::class.java)
    private val adapter = Moshi.Builder().build().adapter<MutableList<ArticleItemBean>>(type)


    @TypeConverter
    fun beanToJson(bean: MutableList<ArticleItemBean>): String {
        return adapter.toJson(bean)
    }

    @TypeConverter
    fun jsonToBean(json: String): MutableList<ArticleItemBean>? {
        return adapter.fromJson(json)
    }
}