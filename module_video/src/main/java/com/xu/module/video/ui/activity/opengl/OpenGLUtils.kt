package com.xu.module.video.ui.activity.opengl

import android.opengl.GLES20

/**
 * @author 许 on 2021/4/18.
 */
object OpenGLUtils {


    /**
     * 编译成GPU程序
     */
    fun loadProgram(vSource: String, fSource: String): Int {
        //顶点着色器
        val vShader = GLES20.glCreateShader(GLES20.GL_VERTEX_SHADER)
        //加载着色器代码
        GLES20.glShaderSource(vShader, vSource)
        //编译着色器
        GLES20.glCompileShader(vShader)
        //查看是否成功
        val status = IntArray(1)
        GLES20.glGetShaderiv(vShader, GLES20.GL_COMPILE_STATUS, status, 0)
        if (status[0] != GLES20.GL_TRUE) {
            throw  IllegalStateException("load vertex shader:" + GLES20.glGetShaderInfoLog(vShader))
        }

        //片元着色器
        val fShader = GLES20.glCreateShader(GLES20.GL_FRAGMENT_SHADER)
        //加载着色代码
        GLES20.glShaderSource(fShader, fSource)
        //编译
        GLES20.glCompileShader(fShader)
        GLES20.glGetShaderiv(fShader, GLES20.GL_COMPILE_STATUS, status, 0)
        if (status[0] != GLES20.GL_TRUE) {
            throw  IllegalStateException("load vertex shader:" + GLES20.glGetShaderInfoLog(fShader))
        }


        //创建着色器程序
        val program = GLES20.glCreateProgram()
        //绑定顶点和片元
        GLES20.glAttachShader(program, vShader)
        GLES20.glAttachShader(program, fShader)
        //链接着色器程序
        GLES20.glLinkProgram(program)
        //获得状态
        GLES20.glGetProgramiv(program, GLES20.GL_LINK_STATUS, status, 0)
        if (status[0] != GLES20.GL_TRUE) {
            throw  IllegalStateException("load vertex shader:" + GLES20.glGetShaderInfoLog(program))
        }
        //着色器已经加载到GPU程序中，可以删除
        GLES20.glDeleteShader(vShader)
        GLES20.glDeleteShader(fShader)
        return program
    }
}