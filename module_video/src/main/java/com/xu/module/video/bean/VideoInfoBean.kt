package com.xu.module.video.bean

data class VideoInfoBean(
    val title: String,
    /**
     * 视频封面地址
     */
    val videoCoverUrl: String,
    /**
     * 视频地址
     */
    val videoUrl: String
)