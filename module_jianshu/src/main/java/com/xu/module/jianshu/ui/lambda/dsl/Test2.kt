package com.xu.module.jianshu.ui.lambda.dsl

/**
 * @author 许 on 2022/3/26.
 */

class Linear1 {
    //这种形式不能传参
    //    fun createFrame(init: (Frame) -> Unit) {
    //        init(Frame())
    //    }
    //比较难理解
    fun createFrame(init: Frame1.(String) -> Unit) {
        Frame1().init("ddd")
    }
}

class Frame1() {
    fun createText(init: Text1.() -> Unit) {
        Text1().init()
    }
}

class Text1 {
    private val aaa: (a: Int) -> Int = {
        a + it
        3
    }
    val bbb = { b: Int ->
        aaa.invoke(3) + b
    }
    val ccc: (b: Int) -> String = fun(b: Int) = b.toString()

    fun test() {
        bbb.invoke(1111)
        val aa = bbb(444)
    }


}

//fun crateLinear(init: (Linear) -> Unit) {
//    init(Linear())
//}
fun linear1(init: Linear1.() -> Unit) {
    init()
}

fun run1() {
    //使用这种形式，不需要用this.createFrame，并且能传参数
    linear1 {
        createFrame { name ->
            createText {

            }
        }

    }
}