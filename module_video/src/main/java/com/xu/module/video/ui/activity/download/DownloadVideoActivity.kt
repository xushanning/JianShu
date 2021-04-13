package com.xu.module.video.ui.activity.download

import android.os.Bundle
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.BaseActivity
import com.xu.module.video.R
import com.xu.module.video.constant.VideoUrlConstant

/**
 * 主要用来学习MediaExtractor
 * 网络读取视频
 */
class DownloadVideoActivity : BaseActivity() {
    override fun setLayoutId(): Int {
        return R.layout.v_activity_download
    }

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun initData() {

        val path = getExternalFilesDir("")?.absolutePath + "download.mp4"
        Logger.d(path)
        DownloadUtil(VideoUrlConstant.videoUrl1, path).startDownload()
    }
}