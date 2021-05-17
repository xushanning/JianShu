package com.xu.module.video.utils

import android.opengl.GLES30

/**
 * @author 许 on 2021/4/18.
 */
object OpenGLUtils {


    /**
     * 编译成GPU程序
     */
    fun loadProgram(vSource: String, fSource: String): Int {
        //顶点着色器
        val vShader = GLES30.glCreateShader(GLES30.GL_VERTEX_SHADER)
        //加载着色器代码
        GLES30.glShaderSource(vShader, vSource)
        //编译着色器
        GLES30.glCompileShader(vShader)
        //查看是否成功
        val status = IntArray(1)
        GLES30.glGetShaderiv(vShader, GLES30.GL_COMPILE_STATUS, status, 0)
        if (status[0] != GLES30.GL_TRUE) {
            throw  IllegalStateException("load vertex shader:" + GLES30.glGetShaderInfoLog(vShader))
        }

        //片元着色器
        val fShader = GLES30.glCreateShader(GLES30.GL_FRAGMENT_SHADER)
        //加载着色代码
        GLES30.glShaderSource(fShader, fSource)
        //编译
        GLES30.glCompileShader(fShader)
        GLES30.glGetShaderiv(fShader, GLES30.GL_COMPILE_STATUS, status, 0)
        if (status[0] != GLES30.GL_TRUE) {
            throw  IllegalStateException("load vertex shader:" + GLES30.glGetShaderInfoLog(fShader))
        }


        //创建着色器程序
        val program = GLES30.glCreateProgram()
        //绑定顶点和片元
        GLES30.glAttachShader(program, vShader)
        GLES30.glAttachShader(program, fShader)
        //链接着色器程序
        GLES30.glLinkProgram(program)
        //获得状态
        GLES30.glGetProgramiv(program, GLES30.GL_LINK_STATUS, status, 0)
        if (status[0] != GLES30.GL_TRUE) {
            throw  IllegalStateException("load vertex shader:" + GLES30.glGetShaderInfoLog(program))
        }
        //着色器已经加载到GPU程序中，可以删除
        GLES30.glDeleteShader(vShader)
        GLES30.glDeleteShader(fShader)
        return program
    }
}