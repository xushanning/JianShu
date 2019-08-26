package com.xu.commonlib.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xu.commonlib.db.entity.TrajectoryEntity
import io.reactivex.Completable
import io.reactivex.Flowable

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
    fun queryHistoryByMonth(year: Int, month: Int): Flowable<List<TrajectoryEntity>>

    /**
     * 通过轨迹id查询此条轨迹的详情
     */
    @Query("select * from sport where trajectoryId==:trajectoryId")
    fun queryHistoryById(trajectoryId: String): Flowable<TrajectoryEntity>

    /**
     *  保存实时轨迹
     */
    @Insert
    fun saveSportTrajectory(entity: TrajectoryEntity): Completable

    /**
     * 更新轨迹
     * 根据主键进行更新
     */
    @Update
    fun updateSportTrajectory(entity: TrajectoryEntity): Completable
}