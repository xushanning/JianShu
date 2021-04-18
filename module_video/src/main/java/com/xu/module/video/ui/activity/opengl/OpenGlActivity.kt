package com.xu.module.video.ui.activity.opengl

import android.os.Bundle
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import com.xu.commonlib.base.BaseActivity
import com.xu.module.video.R
import kotlinx.android.synthetic.main.v_activity_open_gl.*

/**
 * @author 许
 */
class OpenGlActivity : BaseActivity() {


    override fun setLayoutId(): Int {
        return R.layout.v_activity_open_gl
    }

    override fun initView(savedInstanceState: Bundle?) {
        initCamera()
    }

    override fun initData() {

    }

    private fun initCamera() {
        val future = ProcessCameraProvider.getInstance(this)

        future.addListener({
            val preview = Preview
                .Builder()
                .build()
            val provider = future.get()
            camera.attachPreview(preview)
//            provider.unbindAll()
            provider.bindToLifecycle(this, CameraSelector.DEFAULT_BACK_CAMERA, preview)

        }, ContextCompat.getMainExecutor(this))

    }


}