package com.xu.module.video.ui.activity.audio

import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack
import com.orhanobut.logger.Logger
import java.io.File
import java.io.FileInputStream

/**
 * 音频播放线程
 */
class AudioPlayThread(private val pcmName: String) : Thread() {


    /**
     * 采样率为44100
     */
    private val audioRate = 44100

    private val channelConfig = AudioFormat.CHANNEL_IN_STEREO

    /**
     * 设置音频信息属性
     * 设置多媒体属性，如audio，video
     * 设置音频格式，如music
     */
    private val attributes = AudioAttributes.Builder()
        .setUsage(AudioAttributes.USAGE_MEDIA)
        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
        .build()

    /**
     * 设置音频格式
     * 设置采样率
     * 设置采样位数
     * 设置声道
     */
    private val format = AudioFormat.Builder()
        .setSampleRate(audioRate)
        .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
        .setChannelMask(channelConfig)
        .build()

    /**
     * 拿一帧最小buffer大小
     */
    private val bufferSize =
        AudioTrack.getMinBufferSize(audioRate, channelConfig, AudioFormat.ENCODING_PCM_16BIT)

    private val audioTrack = AudioTrack(
        attributes,
        format,
        bufferSize,
        AudioTrack.MODE_STREAM,
        AudioManager.AUDIO_SESSION_ID_GENERATE
    )

    private var isDone = false

    init {
        audioTrack.play()
    }

    override fun run() {
        super.run()
        val file = File(AudioRecordActivity.path, "$pcmName.pcm")
        Logger.d(pcmName)
        Logger.d(file.exists())
        if (file.exists()) {
            val fis = FileInputStream(file)
            val buffer = ByteArray(bufferSize)
            var len = 0

            while (!isDone && fis.read(buffer).also { len = it } > 0) {
                audioTrack.write(buffer, 0, len)
            }
            audioTrack.stop()
            audioTrack.release()
        }
    }

    fun down() {
        isDone = true
    }

}