package com.xu.module.wan.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.xu.module.wan.constant.DbConstant
import com.xu.module.wan.db.converter.SearchHistoryConverter

/**
 * 搜索历史
 */
@Entity(tableName = DbConstant.TABLE_SEARCH_HISTORY)
 @TypeConverters(SearchHistoryConverter::class)
data class SearchHistoryEntity(
    @PrimaryKey
    val id: Int,
    //历史数据，最多保留10条
    val history: MutableList<String>
)