package com.xu.commonlib.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.xu.commonlib.constant.TableConstant
import com.xu.commonlib.db.converter.TrajectoryConvert

/**
 * @author 言吾許
 */
@Entity(tableName = TableConstant.TABLE_SPORT)
@TypeConverters(TrajectoryConvert::class)
class TrajectoryEntity {
    /**
     * 轨迹id
     */
    @PrimaryKey
    var trajectoryId = ""
    /**
     * 运动时间
     */
    var sportTime: Long? = null
    /**
     * 总时长
     */
    var totalTime: Long? = null
    /**
     * 运动的里程
     */
    var sportMileage: Long? = null
    /**
     * 运动是否已经结束 默认未结束
     */
    var complete = false
    /**
     * 开始时间的时间戳
     */
    var startTime: Long? = null
    /**
     * 最后一次入库的时间戳
     * 如果complete为true的话，那么此字段代表结束时间
     */
    var lastInsertTime: Long? = null
    /**
     * 点位信息
     */
    var trajectoryPoints: List<PointBean>? = null
    /**
     * 运动的年份
     */
    var year: Int? = null
    /**
     * 运动的月份
     */
    var month: Int? = null
    /**
     * 哪一天运动的
     */
    var day: Int? = null
}