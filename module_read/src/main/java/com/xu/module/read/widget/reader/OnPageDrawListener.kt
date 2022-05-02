package com.xu.module.read.widget.reader

/**
 * @author 许 on 2022/1/2.
 * 页面绘制监听
 */
interface OnPageDrawListener {
    /**
     *刷新页面
     */
    fun pageInvalidate()

    /**
     * 绘制当前页
     */
    fun drawCurPage()

    /**
     * 绘制下一页
     */
    fun drawNextPage()
}