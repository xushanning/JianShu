package com.xu.module.wan.db

import com.xu.commonlib.utlis.Preference

object AppSp {

    /**
     * 当前登录的用户id
     */
    var currentUserId by Preference("currentUserId", -1)

}