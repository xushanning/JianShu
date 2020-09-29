package com.xu.module.wan.db

import com.xu.commonlib.utlis.Preference

object WanSp {

    /**
     * 当前登录的用户id
     */
    var currentUserId by Preference("currentUserId", -1)

    /**
     * 用户登陆状态
     * 默认为false
     */
    var loginState by Preference("loginState", false)

}