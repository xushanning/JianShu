package com.xu.module.jianshu.ui.kotlin

import com.orhanobut.logger.Logger

/**
 * @author 许 on 2020/6/18.
 */
class InFix(private val number: Int) {

    infix fun sum(other: Int) {
        Logger.d(number + other)
    }

    infix fun add(s: String) {

    }

    fun build() {
        this add "hello"
        add("world")
        val result = 200 calculate 300
        Logger.d(result)
    }

    private infix fun Int.calculate(x: Int): Int {
        return this + x
    }

}