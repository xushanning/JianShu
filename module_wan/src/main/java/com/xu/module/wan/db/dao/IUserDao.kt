package com.xu.module.wan.db.dao

import androidx.lifecycle.MutableLiveData
import androidx.room.Dao

/**
 * @author 许 on 2020/9/10.
 */
@Dao
interface IUserDao {
    fun queryUserInfo(): MutableLiveData<String>
}