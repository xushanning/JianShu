package com.xu.module.video.ui.activity.opengl

import android.content.Context
import android.graphics.SurfaceTexture
import android.opengl.GLES11Ext
import android.opengl.GLES20
import android.opengl.GLSurfaceView
import android.util.AttributeSet
import android.view.Surface
import androidx.camera.core.Preview
import com.xu.commonlib.utlis.AssetUtil
import com.xu.module.video.utils.OpenGLUtils
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer
import java.util.concurrent.Executors
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

/**
 * @author 许
 * open gl
 * https://blog.csdn.net/u012944685/article/details/115503310
 */
class CameraView : GLSurfaceView, GLSurfaceView.Renderer {


    private var textureId: Int? = null
    private var surfaceTexture: SurfaceTexture? = null
    private var programId: Int? = null
    private var vPosition: Int? = null
    private var vCoord: Int? = null
    private var vTexture: Int? = null

    private var vMatrix: Int? = null
    private var textureMatrix = FloatArray(16)

    private var mGLVertexBuffer: FloatBuffer? = null
    private var mGLTextureBuffer: FloatBuffer? = null

    private val executor = Executors.newSingleThreadExecutor()


    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        setEGLContextClientVersion(2)
        //设置renderer
        setRenderer(this)

        /**
         * 设置渲染模式
         * RENDERMODE_WHEN_DIRTY: 手动刷新，需要调用requestRender()
         * RENDERMODE_CONTINUOUSLY：自动刷新，大概16ms自动调用一次onDrawFrame方法
         */
        renderMode = RENDERMODE_WHEN_DIRTY

    }

    override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {
        val ids = IntArray(1)
        GLES20.glGenTextures(1, ids, 0)
        textureId = ids[0]
        surfaceTexture = SurfaceTexture(textureId!!)
        surfaceTexture?.setOnFrameAvailableListener {
            requestRender()
        }
        val vertexShader = AssetUtil.getAssetJson("camera/camera_vert.vsh")
        val fragmentShader = AssetUtil.getAssetJson("camera/camera_frag.fsh")

        programId = OpenGLUtils.loadProgram(vertexShader, fragmentShader)

        vPosition = GLES20.glGetAttribLocation(programId!!, "vPosition")
        vCoord = GLES20.glGetAttribLocation(programId!!, "vCoord")

        vMatrix = GLES20.glGetUniformLocation(programId!!, "vMatrix")
        vTexture = GLES20.glGetUniformLocation(programId!!, "vTexture")

        //四个顶点，每个顶点有两个浮点型，每个浮点型占四个字节
        mGLVertexBuffer =
            ByteBuffer.allocateDirect(4 * 4 * 2).order(ByteOrder.nativeOrder()).asFloatBuffer()
        mGLVertexBuffer?.clear()
        //顶点坐标
        val vertex = floatArrayOf(-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f)
        mGLVertexBuffer?.put(vertex)
        mGLVertexBuffer?.position(0)

        //纹理坐标
        mGLTextureBuffer =
            ByteBuffer.allocateDirect(4 * 4 * 2).order(ByteOrder.nativeOrder()).asFloatBuffer()
        mGLTextureBuffer?.clear()
        //纹理贴图坐标
        val texture = floatArrayOf(0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f)
        // val texture = floatArrayOf(0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f)
        mGLTextureBuffer?.put(texture)
        mGLTextureBuffer?.position(0)

    }

    override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {
        //执行在GL子线程中
        GLES20.glViewport(0, 0, width, height)
    }

    override fun onDrawFrame(gl: GL10?) {


        //更新纹理
        surfaceTexture?.updateTexImage()
        surfaceTexture?.getTransformMatrix(textureMatrix)

        //step0、清屏
//        GLES20.glClearColor(1f, 0f, 0f, 0f)
//        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT)

        //step1、使用着色器
        GLES20.glUseProgram(programId!!)

        //step2、变换矩阵
        GLES20.glUniformMatrix4fv(vMatrix!!, 1, false, textureMatrix, 0)

        //step3、绑定纹理、传递参数
        GLES20.glActiveTexture(GLES20.GL_TEXTURE0)
        GLES20.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, textureId!!)
        GLES20.glUniform1i(vTexture!!, 0)

        //step4、传递坐标数据
        GLES20.glEnableVertexAttribArray(vPosition!!)
        GLES20.glVertexAttribPointer(vPosition!!, 2, GLES20.GL_FLOAT, false, 0, mGLVertexBuffer)


        //step5、传递纹理坐标
        GLES20.glEnableVertexAttribArray(vCoord!!)
        GLES20.glVertexAttribPointer(vCoord!!, 2, GLES20.GL_FLOAT, false, 0, mGLTextureBuffer)


        //step6、通知画画，从第0个开始，共四个点
        GLES20.glDrawArrays(GLES20.GL_TRIANGLE_STRIP, 0, 4)

        //解绑纹理
        //GLES20.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, 0)

        GLES20.glDisableVertexAttribArray(vPosition!!)
        GLES20.glDisableVertexAttribArray(vCoord!!)
    }

    fun attachPreview(preview: Preview) {
        preview.setSurfaceProvider {
            val surface = Surface(surfaceTexture)
            it.provideSurface(surface, executor, {
                surface.release()
                surfaceTexture?.release()
            })

        }
    }

}