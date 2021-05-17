package com.xu.module.video.ui.activity.opengl.shape.renderer

import android.opengl.GLES20
import android.opengl.GLSurfaceView
import android.opengl.Matrix
import com.xu.commonlib.utlis.AssetUtil
import com.xu.module.video.utils.OpenGLUtils
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10
import kotlin.math.cos
import kotlin.math.sin

/**
 * @author 许
 * 圆锥
 */
class ConeRenderer : GLSurfaceView.Renderer {
    private var programId: Int? = null
    private var vPosition: Int? = null
    private var vColor: Int? = null
    private var vMatrix: Int? = null

    private var positionBuffer: FloatBuffer? = null

    private var matrix = FloatArray(16)

    /**
     * 圆锥高度
     */
    private val height = 2.0f

    /**
     * 圆锥地面半径
     */
    private val radius = 1.0f

    /**
     * 切割分数
     */
    private val count = 360

    private var vSize: Int? = null


    override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {
        val vertexShader = AssetUtil.getAssetJson("shape/shape_cone_vertex.vsh")
        val fragmentShader = AssetUtil.getAssetJson("shape/shape_cone_fragment.fsh")
        programId = OpenGLUtils.loadProgram(vertexShader, fragmentShader)
        vPosition = GLES20.glGetAttribLocation(programId!!, "vPosition")
        vColor = GLES20.glGetUniformLocation(programId!!, "vColor")
        vMatrix = GLES20.glGetUniformLocation(programId!!, "vMatrix")


        //准备数据
        val pos = mutableListOf(0.0f, 0.0f, height)
        val span = 360f / count
        var i = 0f
        while (i < 360 + span) {
            pos.add(radius * sin(i * Math.PI / 180f).toFloat())
            pos.add(radius * cos(i * Math.PI / 180f).toFloat())
            pos.add(0.0f)
            i += span
        }
        vSize = pos.size / 3

        //准备位置数据
        positionBuffer =
                //每个浮点数占四个字节
            ByteBuffer.allocateDirect(pos.size * 4).order(ByteOrder.nativeOrder())
                .asFloatBuffer()
        positionBuffer?.clear()
        positionBuffer?.put(pos.toFloatArray())
        positionBuffer?.position(0)

    }

    override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {
        val ratio = width.toFloat() / height
        //todo 矩阵变换有点蒙
        val mViewMatrix = FloatArray(16)
        val mProjectMatrix = FloatArray(16)


        //设置透视投影
        Matrix.frustumM(mProjectMatrix, 0, -ratio, ratio, -1f, 1f, 3f, 7f)
        //设置相机位置
        Matrix.setLookAtM(mViewMatrix, 0, 0f, 0f, 7.0f, 0f, 0f, 0f, 0f, 1.0f, 0.0f)
        //计算变换矩阵
        Matrix.multiplyMM(matrix, 0, mProjectMatrix, 0, mViewMatrix, 0)
    }

    override fun onDrawFrame(gl: GL10?) {
        //清除颜色
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f)
        //将程序加载到opengles2.0环境中
        GLES20.glUseProgram(programId!!)
        //指定vMatrix的值
        GLES20.glUniformMatrix4fv(vMatrix!!, 1, false, matrix, 0)

        //启用三角形顶点的句柄
        GLES20.glEnableVertexAttribArray(vPosition!!)
        //给句柄赋值坐标数据
        GLES20.glVertexAttribPointer(
            vPosition!!,
            3,
            GLES20.GL_FLOAT,
            false,
            //顶点偏移量
            0,
            positionBuffer
        )

        GLES20.glDrawArrays(GLES20.GL_TRIANGLE_FAN, 0, vSize!!)
        GLES20.glDisableVertexAttribArray(vPosition!!)
//        oval.setMatrix(mMVPMatrix)
//        oval.onDrawFrame(gl)
    }
}