package com.xu.module.video.ui.activity.opengl

import android.content.Context
import android.util.Size
import androidx.camera.core.AspectRatio
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner

/**
 * @author 许
 */
object CameraHelper {

    fun cameraInit(owner: LifecycleOwner, context: Context) {
        val future = ProcessCameraProvider.getInstance(context)
        val selector =
            CameraSelector.Builder()
                .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                .build()
        val preview = Preview
            .Builder()
            .setTargetResolution(Size(640, 480))
            .setTargetAspectRatio(AspectRatio.RATIO_16_9)
            .build()
        future.addListener({
            val provider = future.get()


            provider.bindToLifecycle(owner, selector, preview, null)

        }, ContextCompat.getMainExecutor(context))
    }

}