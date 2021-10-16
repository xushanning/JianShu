package com.xu.module.video.ui.activity.opengl.shape.renderer

import android.opengl.GLSurfaceView
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

/**
 * 加载bitmap
 */
class BitmapRenderer : GLSurfaceView.Renderer {

    private var pointBuffer: FloatBuffer? = null

    private var textureBuffer: FloatBuffer? = null


    /**
     * 顶点坐标
     */
    private val pointVertex = floatArrayOf(
        0f, 0f, 0f,
        1f, 1f, 0f,
        -1f, 1f, 0f,
        -1f, -1f, 0f,
        1f, -1f, 0f
    )

    /**
     * 纹理坐标
     */
    private val textureVertex = floatArrayOf(
        0.5f, 0.5f,
        1f, 0f,
        0f, 0f,
        0f, 1f,
        1f, 1f
    )

    /**
     * 索引
     */
    private val indexVertex = shortArrayOf(
        0, 1, 2,
        0, 2, 3,
        0, 3, 4,
        0, 4, 1
    )

    override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {
        pointBuffer = ByteBuffer.allocateDirect(pointVertex.size * 4)
            .order(ByteOrder.nativeOrder())
            .asFloatBuffer()
        pointBuffer?.put(pointVertex)
        pointBuffer?.position(0)




    }

    override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {

    }

    override fun onDrawFrame(gl: GL10?) {

    }
}