package com.xu.module.video.ui.activity.download

import android.media.MediaCodec
import android.media.MediaExtractor
import android.media.MediaFormat
import android.media.MediaMuxer
import com.orhanobut.logger.Logger
import java.nio.ByteBuffer

class DownloadUtil(private val videoUrl: String, private val savePath: String) {

    fun startDownload() {
        Thread {
            download()
        }.start()

    }

    private fun download() {
        //视频大小
        var videoSize = 0
        //音频大小
        var audioSize = 0
        //视频帧率
        var frameRate = 0
        //视频轨道
        var videoTrackIndex = -1
        //音频轨道
        var audioTrackIndex = -1
        //音视频抽取器
        val extractor = createExtractor()

        val videoExtractor = createExtractor()

        val audioExtractor = createExtractor()

        //合成器
        val mediaMuxer = MediaMuxer(savePath, MediaMuxer.OutputFormat.MUXER_OUTPUT_MPEG_4)



        for (index in 0 until extractor.trackCount) {
            val format = extractor.getTrackFormat(index)
            val name = format.getString(MediaFormat.KEY_MIME)
            if (name!!.startsWith("video")) {
                videoExtractor.selectTrack(index)
                videoSize = format.getInteger(MediaFormat.KEY_MAX_INPUT_SIZE)
                frameRate = format.getInteger(MediaFormat.KEY_FRAME_RATE)
                videoTrackIndex = mediaMuxer.addTrack(format)
            } else if (name.startsWith("audio")) {
                audioExtractor.selectTrack(index)
                audioTrackIndex = mediaMuxer.addTrack(format)
                audioSize = format.getInteger(MediaFormat.KEY_MAX_INPUT_SIZE)
            }
        }
        Logger.d("视频大小：$videoSize 视频帧率:$frameRate 视频轨道：$videoTrackIndex")
        Logger.d("音频大小:$audioSize 音频轨道：$audioTrackIndex")

        mediaMuxer.start()

        //循环写视频到复用器
        if (videoTrackIndex != -1) {
            val bufferInfo = MediaCodec.BufferInfo()
            bufferInfo.presentationTimeUs = 0
            val buffer = ByteBuffer.allocate(videoSize)
            while (true) {
                val sampleSize = videoExtractor.readSampleData(buffer, 0)
                if (sampleSize < 0) {
                    break
                }
                bufferInfo.offset = 0
                bufferInfo.size = sampleSize
                bufferInfo.flags = MediaCodec.BUFFER_FLAG_KEY_FRAME
                bufferInfo.presentationTimeUs += 1000 * 1000 / frameRate
                mediaMuxer.writeSampleData(videoTrackIndex, buffer, bufferInfo)
                //如果有下一帧，那么继续循环，没有跳出循环
                if (!videoExtractor.advance()) {
                    break
                }
            }
        }

        //循环写音频到复用器
        if (audioTrackIndex != -1) {
            val bufferInfo = MediaCodec.BufferInfo()
            bufferInfo.presentationTimeUs = 0
            val buffer = ByteBuffer.allocate(audioSize)
            while (true) {
                val sampleSize = audioExtractor.readSampleData(buffer, 0)
                if (sampleSize < 0) {
                    break
                }
                bufferInfo.offset = 0
                bufferInfo.size = sampleSize
                bufferInfo.flags = audioExtractor.sampleFlags
                bufferInfo.presentationTimeUs = audioExtractor.sampleTime
                mediaMuxer.writeSampleData(audioTrackIndex, buffer, bufferInfo)
                if (!audioExtractor.advance()) {
                    break
                }
            }
        }

        //释放抽取器
        videoExtractor.release()
        audioExtractor.release()
        //释放复用器
        mediaMuxer.stop()
        mediaMuxer.release()
        Logger.d("合成完毕")
    }

    private fun createExtractor(): MediaExtractor {
        val extractor = MediaExtractor()
        extractor.setDataSource(videoUrl)
        return extractor
    }
}