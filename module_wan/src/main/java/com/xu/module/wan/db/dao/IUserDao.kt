package com.xu.module.wan.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xu.module.wan.db.entity.UserEntity

/**
 * @author 许 on 2020/9/10.
 */
@Dao
interface IUserDao {
    /**
     * 查询用户信息
     */
    @Query("select * from  user where id ==:userId")
    fun queryUserInfoLiveData(userId: Int): LiveData<UserEntity>

    /**
     * 查询用户信息
     */
    @Query("select * from  user where id ==:userId")
    suspend fun queryUserInfo(userId: Int): UserEntity?

    /**
     * 入库
     */
    @Insert
    suspend fun saveUserInfo(user: UserEntity)

    /**
     * 更新用户数据
     */
    @Update
    suspend fun updateUserInfo(user: UserEntity)
}