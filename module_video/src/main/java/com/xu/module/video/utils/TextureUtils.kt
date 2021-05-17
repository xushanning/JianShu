package com.xu.module.video.utils

import android.content.Context
import android.opengl.GLES30

object TextureUtils {

    fun loadTexture(context: Context, resourceId: Int): Int {
        val ids = IntArray(1)
        GLES30.glGenTextures(1, ids, 0)

    }
}