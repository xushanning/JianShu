package com.xu.module.jianshu.ui.lambda.dsl

import kotlinx.coroutines.MainScope

/**
 * @author 许 on 2022/3/27.
 */


//需求，定义一个三数相加、三数相乘、三数相减的通用函数

//核心思想就是把通用逻辑抽离，lambda里面写独有的逻辑

fun <T> handler(n1: Int, n2: Int, n3: Int, invoke: (Int, Int, Int) -> T?) = invoke(n1, n2, n3)

val ddd = { a: Int, b: Int ->
 
}


fun test() {
    ddd(1, 2)
    val sum = handler(1, 2, 3) { n1, n2, n3 ->
        n1 + n2 + n3
    }
    val multi = handler(1, 2, 3) { n1, n2, n3 ->
        n1 * n2 * n3
    }
    val reduce = handler(1, 2, 3) { n1, n2, n3 ->
        //  100 - n1 - n2 - n3
        null
    }


}

/**
 * 中转类
 */
class Helper<T>(val input: T)

/**
 * 将输入的T类型转换为R类型，而R类型到底是啥，由使用者的lambda来决定
 * 简单来讲：action: T.()就是 input.action()
 * action:(T) 就是action(new T())
 */
fun <R, T> Helper<T>.map(action: T.() -> R): Helper<R> = Helper(input.action())

/**
 * 和上面的相比多了一个传参
 * 其实没啥意义，参数和this都是自己
 */
fun <I, O> Helper<I>.map1(action: I.(I) -> O): Helper<O> = Helper(input.action(input))

/**
 * 最终消费事件
 */
fun <I> Helper<I>.observer(action: I.() -> Unit) = input.action()

/**
 * 创建
 */
fun <I> create(action: () -> I) = Helper(action())


fun test1() {

    create {
        "hello"
    }.map {
        println(this)
        3
    }.map1 {
        println(this)
        println(it)
        this.toString()
    }.map {
        println(this)
        this
    }.observer {
        println(this)
    }
}
