package com.xu.module.read.widget.reader

/**
 * @author 许 on 2022/1/1.
 *一行文字
 */
class SingleLine {
    /**
     * 是否满一行
     */
    var isFullLine = false

    /**
     * 组成一行的char数组
     */
    val chars = mutableListOf<SingleChar>()

    /**
     *已测量的数量
     */
    var measureCount = 0

    fun getLineData(): String {
        return ""
    }
}
