package com.xu.module.video.ui.activity.opengl.shape.renderer

import android.opengl.GLES20
import android.opengl.GLSurfaceView
import android.opengl.Matrix
import com.xu.commonlib.utlis.AssetUtil
import com.xu.module.video.ui.activity.opengl.OpenGLUtils
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

/**
 * @author 许
 * 彩色三角形
 */
class ColorTriangleRenderer : GLSurfaceView.Renderer {
    private var programId: Int? = null
    private var vPosition: Int? = null
    private var vColor: Int? = null
    private var vMatrix: Int? = null

    /**
     * 位置buffer数据
     */
    private var positionBuffer: FloatBuffer? = null

    /**
     * 颜色buffer数据
     */
    private var colorBuffer: FloatBuffer? = null


    //坐标，3D三维数据，

    private val vertex = floatArrayOf(
        0.5f, 0.5f, 0.0f,//顶点的x y z
        -0.5f, -0.5f, 0.0f,//左下角的 x y z
        0.5f, -0.5f, 0.0f//右下角的 x y z

    )


    //三角形颜色数据 RGBA
    private val color = floatArrayOf(
        0.0f, 1.0f, 0.0f, 1.0f,//顶点颜色
        1.0f, 0.0f, 0.0f, 1.0f,//左下角颜色
        0.0f, 0.0f, 1.0f, 1.0f//右下角的颜色
    )

    /**
     * 矩阵
     */
    private val matrix = FloatArray(16)


    //每个顶点有几个坐标组成，这里设置为3个，xyz
    private val perVertexCount = 3

    /**
     * 顶点数量
     */
    private var vertexCount = vertex.size / perVertexCount


    override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {
        val vertexShader = AssetUtil.getAssetJson("shape/shape_color_triangle_vertex.vsh")
        val fragmentShader = AssetUtil.getAssetJson("shape/shape_color_triangle_fragment.fsh")
        programId = OpenGLUtils.loadProgram(vertexShader, fragmentShader)
        vPosition = GLES20.glGetAttribLocation(programId!!, "vPosition")
        vColor = GLES20.glGetAttribLocation(programId!!, "vColor")
        vMatrix = GLES20.glGetUniformLocation(programId!!, "vMatrix")

        //准备位置数据
        positionBuffer =
                //每个浮点数占四个字节
            ByteBuffer.allocateDirect(vertex.size * 4).order(ByteOrder.nativeOrder())
                .asFloatBuffer()
        positionBuffer?.clear()
        positionBuffer?.put(vertex)
        //定位指针位置，从该位置开始读取顶点数据
        positionBuffer?.position(0)


        //准备三角形的颜色数据
        colorBuffer = ByteBuffer.allocateDirect(color.size * 4).order(ByteOrder.nativeOrder())
            .asFloatBuffer()
        colorBuffer?.clear()
        colorBuffer?.put(color)
        colorBuffer?.position(0)

    }

    override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {
        //视口的宽高比
        val ratio = width.toFloat() / height
        //todo 矩阵变换有点蒙
        val mViewMatrix = FloatArray(16)
        val mProjectMatrix = FloatArray(16)

        //设置视口
        //gl?.glViewport(0, 0, width, height)

//        设置矩阵模式为投影模式
        //gl?.glMatrixMode(GL10.GL_PROJECTION)

        //加载单位矩阵
        //gl?.glLoadIdentity()

        //设置平截体视口
        //不太清楚和Matrix.frustumM的关系？
        // 如果规定宽是1的话，那么高度就是ratio
        //3为近平面距离，7为远平面距离
        //gl?.glFrustumf(-1f, 1f, -ratio, ratio, 3f, 7f)

        //设置透视投影，物体越远越小
        Matrix.frustumM(mProjectMatrix, 0, -ratio, ratio, -1f, 1f, 3f, 7f)
        //设置相机位置，一般把centerx放在0 0 0的位置
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
            2,
            GLES20.GL_FLOAT,
            false,
            //顶点偏移量，每个顶点四个字节，乘以顶点数量
            vertexCount * 4,
            positionBuffer
        )

        //启用三角形颜色的句柄
        GLES20.glEnableVertexAttribArray(vColor!!)
        //设置绘制三角形的颜色
        GLES20.glVertexAttribPointer(
            vColor!!, 4,
            GLES20.GL_FLOAT, false,
            0, colorBuffer
        )


        //颜色和坐标都准备好了，开始绘制三角形
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, vertexCount)
        GLES20.glDisableVertexAttribArray(vPosition!!)


    }
}