package com.xu.commonlib.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xu.commonlib.db.entity.TrajectoryEntity
import io.reactivex.Flowable

/**
 * @author 言吾許
 */
@Dao
interface ISportDao {

    @Query("select * from  sport")
    fun queryHistoryTrajectoryList(): Flowable<List<TrajectoryEntity>>

    @Insert
    fun saveSportTrajectory(entity: TrajectoryEntity)

    @Update
    fun updateSportTrajectory(entity: TrajectoryEntity)
}