package com.xu.module.wan.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.xu.module.wan.db.dao.IReadHistoryDao
import com.xu.module.wan.db.dao.ISearchHistoryDao
import com.xu.module.wan.db.dao.IUserDao
import com.xu.module.wan.db.entity.ReadHistoryEntity
import com.xu.module.wan.db.entity.SearchHistoryEntity
import com.xu.module.wan.db.entity.UserEntity

/**
 * @author 许 on 2020/9/10.
 */
@Database(
    entities = [UserEntity::class, ReadHistoryEntity::class, SearchHistoryEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    /**
     * 用户信息Dao
     */
    abstract fun userDao(): IUserDao

    /**
     *浏览历史
     */
    abstract fun readHistoryDao(): IReadHistoryDao

    /**
     * 搜索历史
     */
    abstract fun searchHistoryDao(): ISearchHistoryDao
}