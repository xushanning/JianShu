package com.xu.module.video.ui.activity.opengl.shape.renderer

import android.opengl.GLES20
import android.opengl.GLSurfaceView
import com.orhanobut.logger.Logger
import com.xu.commonlib.utlis.AssetUtil
import com.xu.module.video.ui.activity.opengl.OpenGLUtils
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

/**
 * @author 许
 * 三角形的renderer
 */
class TriangleRenderer : GLSurfaceView.Renderer {
    private var programId: Int? = null
    private var vPosition: Int? = null
    private var vColor: Int? = null
    private var mGLVertexBuffer: FloatBuffer? = null

    //设置颜色，依次为红绿蓝和透明通道
    private val color = floatArrayOf(1.0f, 0f, 1.0f, 1.0f)

    //坐标，3D三维数据，
//    private val vertex = floatArrayOf(
//        1f, 1f, 0.0f,//顶点的x y z
//        0f, 0f, 0.0f,//左下角的 x y z
//        1f, 0f, 0.0f//右下角的 x y z
//    )

    //可以配合 GLES20.GL_TRIANGLES 查看效果
//    private val vertex = floatArrayOf(
//        0.0f, 0.0f, 0.0f,//v0
//        0.0f, 0.5f, 0.0f,//v1
//        -0.5f, 0.0f, 0.0f,//v2
//
//        0.0f, 0.0f, 0.0f, // v0
//        -0.5f, 0.0f, 0.0f, // v2
//        -0.5f, -0.5f, 0.0f,  // v3
//
//        0.0f, 0.0f, 0.0f, // v0
//        -0.5f, -0.5f, 0.0f,  // v3
//        0.5f, -0.5f, 0.0f,  // v4
//
//        0.0f, 0.0f, 0.0f, // v0
//        0.5f, -0.5f, 0.0f,  // v4
//        0.5f, 0.0f, 0.0f,  // v5
//
//        0.0f, 0.0f, 0.0f, // v0
//        0.5f, 0.0f, 0.0f,  // v5
//        0.0f, 0.5f, 0.0f // v1
//    )

    //可以配合GLES20.GL_TRIANGLE_STRIP 查看效果
//    private val vertex = floatArrayOf(
//        0.0f, 0.0f, 0.0f, // v0
//        0.0f, 0.5f, 0.0f, // v1
//        -0.5f, 0.0f, 0.0f, // v2
//        -0.5f, -0.5f, 0.0f,  // v3
//        0.5f, -0.5f, 0.0f,  // v4
//        0.5f, 0.0f, 0.0f,  // v5
//        0.0f, 0.5f, 0.0f, // v1 这里这个v1很重要，不加画出来的东西就很奇怪
//    )

    //可以配合GLES20.GL_TRIANGLE_FAN 查看效果
    private val vertex = floatArrayOf(
        0.0f, 0.0f, 0.0f, // v0
        0.0f, 0.5f, 0.0f, // v1
        -0.5f, 0.0f, 0.0f, // v2
        -0.5f, -0.5f, 0.0f,  // v3
        0.5f, -0.5f, 0.0f,  // v4
        0.5f, 0.0f, 0.0f,  // v5
        //0.0f, 0.5f, 0.0f,//v1，如果加上这行，就会出现五边形了，不加，就缺一块
    )

    override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {
        Logger.d("三角形Create")
        val vertexShader = AssetUtil.getAssetJson("shape/shape_triangle_vertex.vsh")
        val fragmentShader = AssetUtil.getAssetJson("shape/shape_triangle_fragment.fsh")
        programId = OpenGLUtils.loadProgram(vertexShader, fragmentShader)

        vPosition = GLES20.glGetAttribLocation(programId!!, "vPosition")
        vColor = GLES20.glGetUniformLocation(programId!!, "vColor")


        //准备位置数据
        mGLVertexBuffer =
                //每个浮点数占四个字节
            ByteBuffer.allocateDirect(vertex.size * 4).order(ByteOrder.nativeOrder())
                .asFloatBuffer()
        mGLVertexBuffer?.clear()
        mGLVertexBuffer?.put(vertex)
        mGLVertexBuffer?.position(0)
    }

    override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {

    }

    override fun onDrawFrame(gl: GL10?) {
        //清除颜色
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f)
        //将程序加载到opengles2.0环境中
        GLES20.glUseProgram(programId!!)
        //启用三角形顶点的句柄
        GLES20.glEnableVertexAttribArray(vPosition!!)
        //给句柄赋值坐标数据
        GLES20.glVertexAttribPointer(vPosition!!, 3, GLES20.GL_FLOAT, false, 12, mGLVertexBuffer)
        //设置绘制三角形的颜色
        GLES20.glUniform4fv(vColor!!, 1, color, 0)
        //绘制三角形,除以3，是因为采用的，每个点用三个坐标表示
//        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, vertex.size / 3)
        //GLES20.glDrawArrays(GLES20.GL_TRIANGLE_STRIP, 0, vertex.size)
        //Logger.d(vertex)
        GLES20.glDrawArrays(GLES20.GL_TRIANGLE_FAN, 0, vertex.size)
        //Logger.d(vertex.size)
        GLES20.glDisableVertexAttribArray(vPosition!!)
    }
}