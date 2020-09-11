package com.xu.module.wan.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.xu.module.wan.db.dao.IUserDao
import com.xu.module.wan.db.entity.UserEntity

/**
 * @author 许 on 2020/9/10.
 */
@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): IUserDao
}