package com.xu.module.wan.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.xu.module.wan.bean.UserInfoBean
import com.xu.module.wan.constant.DbConstant
import com.xu.module.wan.db.converter.UserInfoConverter


@Entity(tableName = DbConstant.TABLE_USER)
@TypeConverters(UserInfoConverter::class)
data class UserEntity(
    @PrimaryKey
    val id: Int,
    val userInfoBean: UserInfoBean
)