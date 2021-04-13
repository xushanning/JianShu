package com.xu.module.video.ui.activity.audio

import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import android.os.Environment
import com.orhanobut.logger.Logger
import java.io.File
import java.io.FileOutputStream
import java.io.RandomAccessFile

/**
 * 录音线程
 */
class AudioRecordThread(private val wavName: String) : Thread() {
    /**
     * 采样率为44100
     */
    private val audioRate = 44100


    private var isDone = false

    /**
     *
     *双声道
     *采样位数为16bit
     */
    private var minBufferSize = AudioRecord.getMinBufferSize(
        audioRate,
        AudioFormat.CHANNEL_IN_STEREO,
        AudioFormat.ENCODING_PCM_16BIT
    )

    /**
     * 新建record实例，并用他取录音
     */
    private var record = AudioRecord(
        MediaRecorder.AudioSource.MIC,
        audioRate,
        AudioFormat.CHANNEL_IN_STEREO,
        AudioFormat.ENCODING_PCM_16BIT,
        minBufferSize
    )

    override fun run() {
        super.run()
        val dir = File(AudioRecordActivity.path)
        if (!dir.exists()) {
            dir.mkdir()
        }
        //创建pcm文件
        val pcmFile = createFile("$wavName.pcm")
        //创建wav文件
        val wavFile = createFile("$wavName.wav")
        val pcmFos = FileOutputStream(pcmFile)
        val wavFos = FileOutputStream(wavFile)
        val header = createPcmHeader(0, audioRate, record.channelCount)
        wavFos.write(header, 0, header.size)

        //开始录制
        record.startRecording()

        val buffer = ByteArray(minBufferSize)
        while (!isDone) {
            //读取数据
            val read = record.read(buffer, 0, buffer.size)
            if (AudioRecord.ERROR_INVALID_OPERATION != read) {
                //写pcm格式数据
                pcmFos.write(buffer, 0, read)
                //写wav格式数据
                wavFos.write(buffer, 0, read)
            }
        }
        record.stop()
        record.release()

        pcmFos.flush()
        wavFos.flush()

        //修改pcm头部大小
        val randomAccessFile = RandomAccessFile(wavFile, "rw")
        val newHeader = createPcmHeader(pcmFile.length(), audioRate, record.channelCount)
        randomAccessFile.seek(0)
        randomAccessFile.write(newHeader)


    }

    fun done() {
        interrupt()
        isDone = true
    }

    private fun createFile(name: String): File {
        Logger.d(name)
        val file = File(AudioRecordActivity.path, name)
        if (file.exists()) {
            file.delete()
        }
        file.createNewFile()
        return file
    }

    /**
     * @param byteCount 不包括header的音频数据总长度
     * @param sampleRate 录制时使用的采样率
     * @param channels 通道总数
     */
    private fun createPcmHeader(byteCount: Long, sampleRate: Int, channels: Int): ByteArray {
        val totalLen = byteCount + 36
        val byteRate = sampleRate * 2 * channels
        val header = ByteArray(44)
        header[0] = 'R'.toByte()
        header[1] = 'I'.toByte()
        header[2] = 'F'.toByte()
        header[3] = 'F'.toByte()

        header[4] = (totalLen and 0xff).toByte()
        header[5] = (totalLen.shr(8) and 0xff).toByte()
        header[6] = (totalLen.shr(16) and 0xff).toByte()
        header[7] = (totalLen.shr(24) and 0xff).toByte()

        //WAVE
        header[8] = 'W'.toByte()
        header[9] = 'A'.toByte()
        header[10] = 'V'.toByte()
        header[11] = 'E'.toByte()

        //fmt
        header[12] = 'f'.toByte()
        header[13] = 'm'.toByte()
        header[14] = 't'.toByte()
        header[15] = ' '.toByte()

        //数据大小
        header[16] = 16
        header[17] = 0
        header[18] = 0
        header[19] = 0

        //编码方式
        header[20] = 1
        header[21] = 0

        //通道数
        header[22] = channels.toByte()
        header[23] = 0

        //采样率
        header[24] = (sampleRate and 0xff).toByte()
        header[25] = (sampleRate.shr(8) and 0xff).toByte()
        header[26] = (sampleRate.shr(16) and 0xff).toByte()
        header[27] = (sampleRate.shr(24) and 0xff).toByte()

        //音频数据传输速率、采样率*通道数*采样深度/8
        header[28] = (byteRate and 0xff).toByte()
        header[29] = (byteRate.shr(8) and 0xff).toByte()
        header[30] = (byteRate.shr(16) and 0xff).toByte()
        header[31] = (byteRate.shr(24) and 0xff).toByte()

        //确定系统一次要处理多少个这样字节的数据，确定缓冲区 通道数*采样位数
        header[32] = (2 * channels).toByte()
        header[33] = 0

        //每个样本的数据位数
        header[34] = 16
        header[35] = 0

        //data
        header[36] = 'd'.toByte()
        header[37] = 'a'.toByte()
        header[38] = 't'.toByte()
        header[39] = 'a'.toByte()

        header[40] = (byteCount and 0xff).toByte()
        header[41] = (byteCount.shr(8) and 0xff).toByte()
        header[42] = (byteCount.shr(16) and 0xff).toByte()
        header[43] = (byteCount.shr(24) and 0xff).toByte()
        return header
    }

}