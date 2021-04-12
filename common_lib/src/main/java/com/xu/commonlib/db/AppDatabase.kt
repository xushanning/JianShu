package com.xu.commonlib.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.xu.commonlib.db.dao.ISportDao
import com.xu.commonlib.db.dao.IVideoDao
import com.xu.commonlib.db.entity.TrajectoryEntity
import com.xu.commonlib.db.entity.VideoEntity

/**
 * @author 言吾許
 */
//todo 如果将来表增加的话，可以将数据库层单独拆成一个module
//@Database(entities = [TrajectoryEntity::class, VideoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
//    abstract fun sportDao(): ISportDao
//
//    abstract fun videoDao(): IVideoDao
}