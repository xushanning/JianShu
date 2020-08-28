package com.xu.commonlib.db.converter

import androidx.room.TypeConverter
import com.xu.commonlib.db.entity.PointBean

/**
 * @author 言吾許
 * 轨迹convert
 */
class TrajectoryConvert {
  //  private val gson = Gson()

    @TypeConverter
    fun stringToList(value: String?): List<PointBean>? {
//        if (value == null) {
//            return null
//        }
//        val type = object : TypeToken<List<PointBean>>() {}.type
        return null
    }

    @TypeConverter
    fun listToString(list: List<PointBean>?): String? {
        if (list == null) {
            return null
        }
        return ""
    }
}