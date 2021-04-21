package com.xu.module.video.ui.activity.opengl.shape.renderer

import android.opengl.GLES20
import android.opengl.GLSurfaceView
import com.xu.commonlib.utlis.AssetUtil
import com.xu.module.video.ui.activity.opengl.OpenGLUtils
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer
import java.nio.ShortBuffer
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

/**
 * @author 许 正方形
 */
class SquareRenderer : GLSurfaceView.Renderer {
    private var programId: Int? = null
    private var vPosition: Int? = null
    private var vColor: Int? = null
    private var vertexBuffer: FloatBuffer? = null

    private var indexBuffer: ShortBuffer? = null

    /**
     * 正方形坐标 x y z
     */
    private val vertex = floatArrayOf(
        -0.5f, 0.5f, 0.0f,//第一个点
        -0.5f, -0.5f, 0.0f,//第二个点
        0.5f, -0.5f, 0.0f,//第三个点
        0.5f, 0.5f, 0.0f//第四个点
    )

    //索引,每次取三个值，这个值是一个索引，代表在vertex中的位置
    //比如：0,1,2 这个对应的vertex中的一、二、三，这三个点，然后绘制出一个三角形
    //然后在2,3,0, 这个对应vertex中的二、三、一，这三个点，按照逆时针顺序绘制出一个三角形
    //两个三角形，想拼接，就出了一个正方形
    private val index = shortArrayOf(0, 1, 2, 2, 3, 0)

    /**
     * 颜色
     */
    private val color = floatArrayOf(1.0f, 1.0f, 1.0f, 1.0f)

    override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {
        val vertexShader = AssetUtil.getAssetJson("shape/shape_triangle_vertex.vsh")
        val fragmentShader = AssetUtil.getAssetJson("shape/shape_triangle_fragment.fsh")
        programId = OpenGLUtils.loadProgram(vertexShader, fragmentShader)
        vPosition = GLES20.glGetAttribLocation(programId!!, "vPosition")
        vColor = GLES20.glGetUniformLocation(programId!!, "vColor")

        //准备位置数据
        vertexBuffer =
                //每个浮点数占四个字节
            ByteBuffer.allocateDirect(vertex.size * 4).order(ByteOrder.nativeOrder())
                .asFloatBuffer()
        vertexBuffer?.clear()
        vertexBuffer?.put(vertex)
        vertexBuffer?.position(0)

        indexBuffer =
            ByteBuffer.allocateDirect(index.size * 2).order(ByteOrder.nativeOrder()).asShortBuffer()
        indexBuffer?.clear()
        indexBuffer?.put(index)
        indexBuffer?.position(0)

    }

    override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {

    }

    override fun onDrawFrame(gl: GL10?) {
        //清除颜色
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f)
        //将程序加载到opengles2.0环境中
        GLES20.glUseProgram(programId!!)
        //启用顶点的句柄
        GLES20.glEnableVertexAttribArray(vPosition!!)
        //给句柄赋值坐标数据
        GLES20.glVertexAttribPointer(vPosition!!, 3, GLES20.GL_FLOAT, false, 12, vertexBuffer)

        //设置绘制三角形的颜色
        GLES20.glUniform4fv(vColor!!, 1, color, 0)

        /**
         *索引法绘制正方形
         * 1、绘制方式
         * 2、绘制数量
         * 3、索引的数据类型：必须是GL_UNSIGNED_BYTE或GL_UNSIGNED_SHORT
         * 4、索引缓冲
         */
        GLES20.glDrawElements(
            GLES20.GL_TRIANGLES,
            index.size,
            GLES20.GL_UNSIGNED_SHORT,
            indexBuffer
        )

        //禁止顶点数组的句柄
        GLES20.glDisableVertexAttribArray(vPosition!!)
    }
}