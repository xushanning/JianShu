package com.xu.module.read.widget.reader

/**
 * @author 许 on 2022/1/3.
 * 读书配置
 */
class ReadConfig {
    /**
     * 正文字体大小
     */
    var textSize = 60

    /**
     * 行间距
     */
    var lineSpace = 10f

    /**
     * 阅读view的宽度
     */
    var viewWidth = 0

    /**
     * 阅读view的高度
     */
    var viewHeight = 0

    /**
     * 正文距离四周的padding
     * 0,1,2,3分别是上下左右
     */
    var padding = listOf(10, 10, 10, 10)

}