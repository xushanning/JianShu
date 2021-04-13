package com.xu.module.video.ui.activity.audio

import android.content.Intent
import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.view.MotionEvent
import androidx.core.content.FileProvider
import com.xu.commonlib.base.BaseActivity
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.module.video.R
import kotlinx.android.synthetic.main.v_activity_audio_record.*
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileInputStream

/**
 *进行音频录制
 */
class AudioRecordActivity : BaseActivity() {
    /**
     * 录制线程
     */
    private var recordThread: AudioRecordThread? = null

    /**
     * 播放线程
     */
    private var playThread: AudioPlayThread? = null

    private var wavName = "test"
    private var pcmName = "test"

    /**
     * 采样率为44100
     */
    private val audioRate = 44100

    companion object {
        val path = Environment.getExternalStorageDirectory().absolutePath + "/VideoRecord"
    }


    override fun setLayoutId(): Int {
        return R.layout.v_activity_audio_record
    }

    override fun initView(savedInstanceState: Bundle?) {
        bt_record.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    startRecord()
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_DOWN -> {
                    recordThread?.done()
                }

            }
            false
        }

        bt_play_wav.singleClick {
            playWav()
        }

        tv_play_pcm_stream.singleClick {
            playThread?.down()
            playThread = null
            playThread = AudioPlayThread(pcmName)
            playThread?.start()
        }

        tv_play_pcm_static.singleClick {
            playPcm2()
        }
    }

    override fun initData() {

    }

    private fun startRecord() {
        recordThread?.done()
        recordThread = null
        recordThread = AudioRecordThread(wavName)
        recordThread?.start()
    }

    private fun playWav() {
        val file = File(path, "$wavName.wav")
        if (file.exists()) {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            val uri = if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
                FileProvider.getUriForFile(this, "com.xu.module.video.fileprovider", file)
            } else {
                Uri.fromFile(file.absoluteFile)
            }
            intent.setDataAndType(uri, "audio")
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            startActivity(intent)
        } else {
            showToast("先录制")
        }

    }

    //static和stream最大的区别，就是一次性的全部写进去
    private fun playPcm2() {
        val file = File(path, "$pcmName.pcm")
        val input = FileInputStream(file)
        val baos = ByteArrayOutputStream()
        var len = 0
        val buffer = ByteArray(1024)
        while (input.read(buffer).also { len = it } > 0) {
            baos.write(buffer, 0, len)
        }
        //拿到音频数据
        val bytes = baos.toByteArray()
        val channelConfig = AudioFormat.CHANNEL_IN_STEREO
        val attributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .build()

        val format = AudioFormat.Builder()
            .setSampleRate(audioRate)
            .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
            .setChannelMask(channelConfig)
            .build()

        val audioTrack = AudioTrack(
            attributes,
            format,
            bytes.size,
            AudioTrack.MODE_STATIC,
            AudioManager.AUDIO_SESSION_ID_GENERATE
        )
        audioTrack.write(bytes, 0, bytes.size)
        audioTrack.play()

    }
}