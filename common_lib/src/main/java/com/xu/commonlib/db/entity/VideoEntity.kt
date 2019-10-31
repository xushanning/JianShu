package com.xu.commonlib.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.xu.commonlib.constant.TableConstant

/**
 * @author 言吾許
 */
@Entity(tableName = TableConstant.TABLE_VIDEO)
class VideoEntity {
    /**
     * 轨迹id
     */
    @PrimaryKey
    var id = ""
}