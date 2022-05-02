package com.xu.module.jianshu.ui.lambda.dsl

import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseBinderAdapter
import com.xu.commonlib.utlis.extention.navigate

/**
 * @author 许 on 2022/3/26.
 */

class Linear {
    fun createFrame(init: (Frame) -> Unit) {
        init(Frame())
    }
}

class Frame {
    fun createText(init: (Text) -> Unit) {
        init(Text())
    }
}

class Text {

}


fun crateLinear(init: (Linear) -> Unit) {
    init(Linear())
}

class Response(var code: Int) {

}

//好好理解
fun login(userName: String, password: String, result: (Response) -> Unit) {
    if (userName == "xxx" && password == "ddd") {
        result(Response(200))
    }
    result(Response(404))
}

//好好理解
fun login2(userName: String, password: String, result: Response.(String) -> Unit) {
    if (userName == "xxx" && password == "ddd") {
        Response(200).result("success")
    }
    Response(404).result("fail")
}

fun run() {
    crateLinear { linear ->
        //这种形式不能传参数，因为it就是frame
        linear.createFrame {
            it.createText {

            }
        }
    }
    login("xxx", "333") {
        if (it.code == 200) {
            println("登陆成功")
        }
    }
    login2("", "") {
        if (it == "success") {

        }
    }
    val result = 55.hello {
        println("name" + it + this)
        true
    }
    val result2 = 44.hello2 {
        println("name" + it)
        true
    }
    val result3 = Student().hello3 {
        println(it.name + this.name)
        true
    }
    val result4 = Student().hello4 {

        true
    }
}

fun <T> T.hello(invoke: T.(String) -> Boolean): Boolean {
    //调用lambda让其生效
    return invoke("许善宁")
}

fun <T> T.hello2(invoke: (String) -> Boolean): Boolean {

    return invoke("xxx")
}

//这种形式invoke传T类型,完全可以当成面试面试题
fun <T : Person> T.hello3(invoke: T.(T) -> Boolean): Boolean {
    return invoke(this)
}

//简洁化
fun <T : Person> T.hello4(invoke: T.(T) -> Boolean) = invoke(this)

open class Person {

}

class Student : Person() {
    val name: String = ""
}
