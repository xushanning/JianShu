package com.xu.module.wan.utils.ext

import com.xu.module.wan.bean.HotKeyBean

/**
 * 随时热词
 */
fun MutableList<HotKeyBean>.getHotKey(): String {
    var hotKey = "EasyLoad使用 | 快来Start一下项目吧"
    if (size > 0) {
        if (size == 1) {
            hotKey = get(0).name
        }
        if (size >= 2) {
            //随机两个不重复的
            val first = (0 until size).random()
            var second = (0 until size).random()
            while (first == second) {
                second = (0 until size).random()
            }
            hotKey = get(first).name + " | " + get(second).name
        }
    }
    return hotKey
}