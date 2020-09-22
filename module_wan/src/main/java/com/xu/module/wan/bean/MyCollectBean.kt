package com.xu.module.wan.bean

import com.squareup.moshi.JsonClass

/**
 * 我的收藏
 */
@JsonClass(generateAdapter = true)
data class MyCollectBean(
    var chapterId: Int,
    var author: String,
    var chapterName: String,
    var courseId: Int,
    var desc: String,
    var envelopePic: String,
    var id: Int,
    var link: String,
    var niceDate: String,
    var origin: String,
    var originId: Int,
    var publishTime: Long,
    var title: String,
    var userId: Int,
    var visible: Int,
    var zan: Int
)