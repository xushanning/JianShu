package com.xu.module.video.ui.activity.opengl.shape

import android.content.Context
import android.opengl.GLES20
import android.opengl.GLSurfaceView
import android.util.AttributeSet
import com.orhanobut.logger.Logger
import com.xu.module.video.ui.activity.opengl.shape.renderer.*
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

/**
 * @author 许
 * 形状绘制view
 */
class ShapeSurfaceView : GLSurfaceView, GLSurfaceView.Renderer {


    private var shapeId = 0
    private var shapeRenderer: Renderer? = null

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initGl()
    }

    private fun initGl() {
        setEGLContextClientVersion(2)
        setRenderer(this)
        renderMode = RENDERMODE_WHEN_DIRTY
    }

    fun refresh(id: Int) {
        this.shapeId = id
        requestRender()
    }

    override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {
        shapeRenderer = when (shapeId) {
            1 -> TriangleRenderer()
            2 -> EquilateralTriangleRenderer()
            3 -> ColorTriangleRenderer()
            4 -> SquareRenderer()
            5 -> RoundRenderer()
            6 -> CubeRenderer()
            7 -> ConeRenderer()
            8 -> CylinderRenderer()
            9 -> SphereRenderer()
            10 -> LightSphereRenderer()
            11 -> BitmapRenderer()
            else -> TriangleRenderer()
        }
        shapeRenderer?.onSurfaceCreated(gl, config)


    }

    override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {
        GLES20.glViewport(0, 0, width, height)
        shapeRenderer?.onSurfaceChanged(gl, width, height)
    }

    override fun onDrawFrame(gl: GL10?) {
        shapeRenderer?.onDrawFrame(gl)
    }
}