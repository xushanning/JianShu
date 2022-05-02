package com.xu.module.read

import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun test() {
        create {
            "hello"
        }.map1 {
            println(it)
            println(this)
            3
        }.map {
            println(this)
            this.toString() + "dddddd"
        }.observer {
            println(this)
        }
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


fun <I> create(action: () -> I) = Helper(action())