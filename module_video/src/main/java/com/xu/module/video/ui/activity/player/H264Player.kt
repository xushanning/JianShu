package com.xu.module.video.ui.activity.player

import android.icu.text.IDNA
import android.media.MediaCodec
import android.media.MediaFormat
import android.view.Surface
import java.io.ByteArrayOutputStream
import java.io.DataInputStream
import java.io.File
import java.io.FileInputStream

/**
 * @author 许
 * H264解码器
 */
class H264Player(private val path: String, private val surface: Surface) : Thread() {
    /**
     * 解码器
     */
    private val mediaCodec = MediaCodec.createDecoderByType("video/avc")

    private val format = MediaFormat.createVideoFormat("video/avc", 368, 384)


    init {
        //设置帧率
        format.setInteger(MediaFormat.KEY_FRAME_RATE, 33)
        mediaCodec.configure(format, surface, null, 0)
    }

    fun play() {
        mediaCodec.start()
        start()
    }

    override fun run() {
        decodeH264()
    }

    /**
     * 解码h264
     */
    private fun decodeH264() {
        val bytes = getBytes()
        //开始位置
        var startIndex = 0
        while (true) {
            //结束索引,+3是为了防止还是返回0
            val nextFrameStart = findFrame(bytes, startIndex + 3)
            //查找空闲容器索引，属于输入队列
            val inIndex = mediaCodec.dequeueInputBuffer(10000)
            val info = MediaCodec.BufferInfo()
            if (inIndex >= 0) {
                //把容器取出来
                val byteBuffer = mediaCodec.getInputBuffer(inIndex)
                //不能直接丢进去 byteBuffer.put(bytes)
                //而是找到起始点的索引，找到中间的字节数据，也就是完整帧
                byteBuffer?.put(bytes, startIndex, nextFrameStart - startIndex)

                //丢索引
                mediaCodec.queueInputBuffer(inIndex, 0, nextFrameStart - startIndex, 0, 0)
                startIndex = nextFrameStart
            } else {
                continue
            }
            //开始取数据，需要找一个输出队列
            val outIndex = mediaCodec.dequeueOutputBuffer(info, 10000)
            if (outIndex >= 0) {
                //为了解决同步
                sleep(33)
                // 说明解码完毕
                mediaCodec.releaseOutputBuffer(outIndex, true)
            }
        }
    }

    /**
     * 找到下一个分割点
     * 分割点有两种：
     * 00 00 00 01
     * 00 00 01
     */
    private fun findFrame(bytes: ByteArray, start: Int): Int {
        for (i in start until bytes.size - 4) {
            val res =
                (bytes[i] == 0x00.toByte() && bytes[i + 1] == 0x00.toByte() && bytes[i + 2] == 0x00.toByte() && bytes[i + 3] == 0x01.toByte()) ||
                        (bytes[i] == 0x00.toByte() && bytes[i + 1] == 0x00.toByte() && bytes[i + 2] == 0x01.toByte())
            if (res) {
                return i
            }
        }

        //没找到分割点
        return -1
    }

    /**
     * 将视频文件通过流的方式读到内存
     */
    private fun getBytes(): ByteArray {
        val input = DataInputStream(FileInputStream(File(path)))
        var len: Int
        val size = 1024
        val buf = ByteArray(size)
        val bos = ByteArrayOutputStream()
        while (input.read(buf, 0, size).also { len = it } != -1) {
            bos.write(buf, 0, len)
        }
        return bos.toByteArray()
    }
}
