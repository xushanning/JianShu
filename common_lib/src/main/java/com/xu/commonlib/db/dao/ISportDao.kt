package com.xu.commonlib.db.dao

import androidx.room.*
import com.xu.commonlib.db.entity.TrajectoryEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

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
    @Query("select * from  sport where year ==:year and month==:month and complete=1")
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

    /**
     * 删除某条轨迹
     */
    @Delete
    fun deleteSportTrajectory(entity: TrajectoryEntity): Single<Int>

    /**
     * 查询某个月的某种运动类型的所有轨迹
     * 查询条件：年份、月份、运动类型、运动已经完成
     * complete:1代表完成的巡河 0代表未完成的
     */
    @Query("select * from sport where year==:year and month==:month and sportType==:sportType and complete =1")
    fun queryCurrentMonthHistoryByType(sportType: Int, year: Int, month: Int): Flowable<List<TrajectoryEntity>>
}