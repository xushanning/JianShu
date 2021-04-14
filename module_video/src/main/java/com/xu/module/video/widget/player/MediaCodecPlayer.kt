package com.xu.module.video.widget.player

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.Surface
import android.widget.FrameLayout
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.module.video.R
import kotlinx.android.synthetic.main.v_activity_audio_record.view.*
import kotlinx.android.synthetic.main.v_view_media_codec_player.view.*

class MediaCodecPlayer : FrameLayout, IVideoPlayer {

    private var videoDecoder: VideoDecoder? = null

    /**
     * surface view
     */
    private val surfaceTypeSurfaceView = 1
    private val surfaceTypeTextureView = 2

    private lateinit var surface: Surface

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(attrs)
        initDecoder()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private fun initView(attrs: AttributeSet?) {
//        val typeArray =
//            context.theme.obtainStyledAttributes(attrs, R.styleable.v_video_player, 0, 0)
//        val surfaceType =
//            typeArray.getInt(R.styleable.v_video_player_v_surface_type, surfaceTypeSurfaceView)
//        val resizeMode = typeArray.getInt(R.styleable.v_video_player_v_resize_mode, 0)
//        typeArray.recycle()
        LayoutInflater.from(context).inflate(R.layout.v_view_media_codec_player, this)
        surface = sv_video.holder.surface
        img_control.singleClick {

        }
    }

    private fun initDecoder() {
        if (videoDecoder == null) {
            videoDecoder?.release()
            videoDecoder = null
        }
        videoDecoder = VideoDecoder()
    }

    override fun prepare() {

    }

    override fun play() {
    }

    override fun pause() {
    }

    override fun resume() {
    }
}