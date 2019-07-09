package com.xu.commonlib.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xu.commonlib.db.entity.TrajectoryEntity
import io.reactivex.Flowable
import java.time.Month

/**
 * @author 言吾許
 */
@Dao
interface ISportDao {

    @Query("select * from  sport")
    fun queryHistoryTrajectoryList(): Flowable<List<TrajectoryEntity>>

    /**
     * 查询所有的历史记录
     */
    @Query("select * from  sport")
    fun queryAllHistory(): Flowable<List<TrajectoryEntity>>

    /**
     * 查询某一年的数据
     */
    @Query("select * from  sport where year ==:year")
    fun queryHistoryByYear(year: Int): Flowable<List<TrajectoryEntity>>

    /**
     * 查询某年某月的运动记录
     */
    @Query("select * from  sport where year ==:year and month==:month")
    fun queryHistoryByMonth(year: Int, month: Month): Flowable<List<TrajectoryEntity>>

    @Insert
    fun saveSportTrajectory(entity: TrajectoryEntity)

    @Update
    fun updateSportTrajectory(entity: TrajectoryEntity)
}