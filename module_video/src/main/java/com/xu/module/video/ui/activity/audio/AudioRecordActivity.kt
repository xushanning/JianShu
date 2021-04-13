package com.xu.module.video.ui.activity.audio

import android.content.Intent
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
import java.io.File

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

        }

        tv_play_pcm_static.singleClick {

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
}