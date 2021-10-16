package com.xu.module.video.debug

import androidx.camera.camera2.Camera2Config
import androidx.camera.core.CameraXConfig
import com.xu.commonlib.base.BaseApplication
import dagger.hilt.android.HiltAndroidApp

/**
 * @author 言吾許
 */
@HiltAndroidApp
class DebugApplication : BaseApplication(), CameraXConfig.Provider {
    override fun getCameraXConfig(): CameraXConfig {
        return Camera2Config.defaultConfig()
    }

}