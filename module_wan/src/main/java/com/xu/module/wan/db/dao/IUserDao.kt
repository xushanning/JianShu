package com.xu.module.wan.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.xu.module.wan.db.entity.UserEntity

/**
 * @author 许 on 2020/9/10.
 */
@Dao
interface IUserDao {
    /**
     * 查询用户信息
     */
    @Query("select * from  user")
    fun queryUserInfo(): LiveData<MutableList<UserEntity>>

    /**
     * 入库
     */
    @Insert
    fun saveUserInfo(user: UserEntity)
}