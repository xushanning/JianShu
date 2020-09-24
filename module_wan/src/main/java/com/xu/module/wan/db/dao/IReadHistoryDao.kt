package com.xu.module.wan.db.dao

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xu.module.wan.db.entity.ReadHistoryEntity

/**
 * 浏览历史Dao
 */
@Dao
interface IReadHistoryDao {

    /**
     * 查询指定用户的阅读历史记录
     */
    @Query("select * from read_history where userId==:userId")
    fun queryReadHistoryById(userId: Int): LiveData<ReadHistoryEntity?>

    /**
     * 带有paging返回的查询
     */
    @Query("select * from read_history where userId==:userId")
    fun queryReadHistoryPaging(userId: Int): PagingSource<Int, ReadHistoryEntity>

    @Query("select * from read_history where userId==:userId")
    suspend fun queryReadHistory(userId: Int): ReadHistoryEntity?

    /**
     * 入库
     */
    @Insert
    suspend fun saveHistory(entity: ReadHistoryEntity)

    /**
     * 更新
     */
    @Update
    suspend fun updateHistory(entity: ReadHistoryEntity)

}