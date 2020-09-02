package com.xu.module.wan.bean

import com.squareup.moshi.JsonClass

/**
 * 登陆返回用户bean
 */
@JsonClass(generateAdapter = true)
data class UserInfoBean(
    val admin: Boolean,
    val chapterTops: List<Any>,
    val coinCount: Int,
    val collectIds: List<Any>,
    val email: String,
    val icon: String,
    //生成的唯一id
    val id: Int,
    val nickname: String,
    val password: String,
    val publicName: String,
    val token: String,
    val type: Int,
    //用户名
    val username: String
)