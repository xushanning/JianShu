package com.xu.module.video.widget.player

interface IVideoPlayer {
    /**
     * 准备
     */
    fun prepare()

    /**
     * 开始
     */
    fun play()

    /**
     * 暂停
     */
    fun pause()

    /**
     * 恢复
     */
    fun resume()

}