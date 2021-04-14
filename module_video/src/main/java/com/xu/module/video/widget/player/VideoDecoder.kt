package com.xu.module.video.widget.player

import android.media.MediaCodec
import android.media.MediaExtractor
import android.media.MediaFormat
import android.view.Surface
import com.orhanobut.logger.Logger
import com.xu.module.video.constant.VideoUrlConstant

/**
 * 解码器
 */
class VideoDecoder(private val surface: Surface) {

    private var mediaCodec: MediaCodec? = null

    private var mediaExt: MediaExtractor? = null

    /**
     *视频轨道索引
     */
    private var videoTrackIndex = -1

    /**
     * 视频高度
     */
    private var videoHeight = 0

    /**
     * 视频宽度
     */
    private var videoWidget = 0

    /**
     * 视频帧率
     */
    private var videoFrameRate = 0

    /**
     * 视频时长
     */
    private var videoDuration = 0L

    /**
     * 视频地址
     */
    private val videoPath = VideoUrlConstant.videoUrl1


    fun play() {
        initMediaCodec()
        val playThread = Thread {
            while (true) {
                handleInputVideo()
                handleOutPutVideo()
            }

        }.start()

    }

    /**
     * 初始化解码器
     */
    private fun initMediaCodec() {
        mediaExt = MediaExtractor()
        mediaExt?.setDataSource(videoPath)
        videoTrackIndex = getTrack("video/")
        if (videoTrackIndex >= 0) {
            mediaExt!!.selectTrack(videoTrackIndex)
            val format = mediaExt?.getTrackFormat(videoTrackIndex)
            videoHeight = format!!.getInteger(MediaFormat.KEY_HEIGHT)
            videoWidget = format.getInteger(MediaFormat.KEY_WIDTH)
            videoDuration = format.getLong(MediaFormat.KEY_DURATION)
            videoFrameRate = format.getInteger(MediaFormat.KEY_FRAME_RATE)
            Logger.d("视频宽高:$videoWidget x$videoHeight 视频时长:$videoDuration 视频帧率:$videoFrameRate")
        }

    }

    private fun getTrack(mineType: String): Int {
        for (index in 0 until mediaExt!!.trackCount) {
            val mine = mediaExt!!.getTrackFormat(index).getString(MediaFormat.KEY_MIME)
            if (mine.startsWith(mineType)) {
                return index
            }
        }

        return -1
    }

    fun release() {

    }

    /**
     * 处理输入
     */
    private fun handleInputVideo() {

    }

    /**
     * 输入一帧数据到 解码器
     */
    private fun readFrame() {
        while (true) {

        }
    }

    /**
     * 输出一帧数据到surface
     */
    private fun handleOutPutVideo() {

    }


}