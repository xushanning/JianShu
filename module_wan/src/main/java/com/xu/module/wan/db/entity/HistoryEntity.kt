package com.xu.module.wan.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.xu.module.wan.constant.DbConstant

/**
 * 浏览历史Entity
 */
@Entity(tableName = DbConstant.TABLE_HISTORY)
data class HistoryEntity(
    @PrimaryKey
    val id: Int,
    val xx: String
)