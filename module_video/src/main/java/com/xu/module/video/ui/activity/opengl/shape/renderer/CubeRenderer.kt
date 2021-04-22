package com.xu.module.video.ui.activity.opengl.shape.renderer

import android.opengl.GLES20
import android.opengl.GLSurfaceView
import android.opengl.Matrix
import com.xu.commonlib.utlis.AssetUtil
import com.xu.module.video.ui.activity.opengl.OpenGLUtils
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer
import java.nio.ShortBuffer
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

/**
 * @author 许
 * 正方体
 */
class CubeRenderer : GLSurfaceView.Renderer {
    private var programId: Int? = null
    private var vPosition: Int? = null
    private var vColor: Int? = null
    private var vMatrix: Int? = null

    private var matrix = FloatArray(16)

    /**
     * 位置buffer数据
     */
    private var positionBuffer: FloatBuffer? = null

    /**
     * 位置float数据
     */
    private var vertex = floatArrayOf(
        -1.0f, 1.0f, 1.0f,    //正面左上0
        -1.0f, -1.0f, 1.0f,   //正面左下1
        1.0f, -1.0f, 1.0f,    //正面右下2
        1.0f, 1.0f, 1.0f,     //正面右上3
        -1.0f, 1.0f, -1.0f,    //反面左上4
        -1.0f, -1.0f, -1.0f,   //反面左下5
        1.0f, -1.0f, -1.0f,    //反面右下6
        1.0f, 1.0f, -1.0f,     //反面右上7
    )


    /**
     * 颜色buffer数据
     */
    private var colorBuffer: FloatBuffer? = null


    private val color = floatArrayOf(
        0f, 1f, 0f, 1f,
        0f, 1f, 0f, 1f,
        0f, 1f, 0f, 1f,
        0f, 1f, 0f, 1f,
        1f, 0f, 0f, 1f,
        1f, 0f, 0f, 1f,
        1f, 0f, 0f, 1f,
        1f, 0f, 0f, 1f,
    )

    /**
     * 索引buffer
     */
    private var indexBuffer: ShortBuffer? = null

    /**
     * 索引值
     */
    private val index = shortArrayOf(
        6, 7, 4, 6, 4, 5,    //后面
        6, 3, 7, 6, 2, 3,    //右面
        6, 5, 1, 6, 1, 2,    //下面
        0, 3, 2, 0, 2, 1,    //正面
        0, 1, 5, 0, 5, 4,    //左面
        0, 7, 3, 0, 4, 7,    //上面
    )

    override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {
        val vertexShader = AssetUtil.getAssetJson("shape/shape_cube_vertex.vsh")
        val fragmentShader = AssetUtil.getAssetJson("shape/shape_cube_fragment.fsh")

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
        positionBuffer?.position(0)


        //准备三角形的颜色数据
        colorBuffer = ByteBuffer.allocateDirect(color.size * 4).order(ByteOrder.nativeOrder())
            .asFloatBuffer()
        colorBuffer?.clear()
        colorBuffer?.put(color)
        colorBuffer?.position(0)


        //准备index数据
        indexBuffer =
            ByteBuffer.allocateDirect(index.size * 2).order(ByteOrder.nativeOrder()).asShortBuffer()
        indexBuffer?.clear()
        indexBuffer?.put(index)
        indexBuffer?.position(0)
    }

    override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {
        //计算宽高比
        val ratio = width.toFloat() / height
        val mViewMatrix = FloatArray(16)
        val mProjectMatrix = FloatArray(16)
        //设置透视投影
        Matrix.frustumM(mProjectMatrix, 0, -ratio, ratio, -1f, 1f, 3f, 20f)
        //设置相机位置(视图矩阵)
        Matrix.setLookAtM(mViewMatrix, 0, 5.0f, 5.0f, 10.0f, 0f, 0f, 0f, 0f, 1.0f, 0.0f)
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
            0,
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
        GLES20.glDrawElements(
            GLES20.GL_TRIANGLES,
            index.size,
            GLES20.GL_UNSIGNED_SHORT,
            indexBuffer
        )
        GLES20.glDisableVertexAttribArray(vPosition!!)
    }
}