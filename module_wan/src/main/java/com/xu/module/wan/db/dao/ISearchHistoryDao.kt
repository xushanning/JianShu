package com.xu.module.wan.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xu.module.wan.db.entity.SearchHistoryEntity

/**
 * 搜索历史Dao
 */
@Dao
interface ISearchHistoryDao {
    /**
     * 查询当前用户的搜索历史(LiveData)
     */
    @Query("select * from search_history where id ==:userId")
    fun querySearchHistoryLiveData(userId: Int): LiveData<SearchHistoryEntity?>



    /**
     * 入库
     */
    @Insert
    suspend fun saveHistory(entity: SearchHistoryEntity)

    /**
     * 更新
     */
    @Update
    suspend fun updateHistory(entity: SearchHistoryEntity)

    /**
     * 删除全部的搜索记录
     */
    //  fun deleteAllSearchHistory(userId: Int)
}