package com.xu.module.wan.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.xu.module.wan.bean.ArticleItemBean
import com.xu.module.wan.constant.DbConstant
import com.xu.module.wan.db.converter.ArticleConverter

/**
 * 浏览历史Entity
 */
@Entity(tableName = DbConstant.TABLE_READ_HISTORY)
@TypeConverters(ArticleConverter::class)
data class ReadHistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    /**
     * 用户id
     */
    val userId: Int,
    /**
     * 浏览的数据
     */
    val articles: MutableList<ArticleItemBean>
)