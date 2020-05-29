package com.xu.module.jianshu.ui.retrofit

import com.orhanobut.logger.Logger
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

/**
 * @author 言吾許
 * 模拟retrofit实现过程
 */
@Suppress("UNCHECKED_CAST")
class Retrofit(var callFactory: Call.Factory, var baseUrl: String) {


    fun <T> create(service: Class<T>): T {
        return Proxy.newProxyInstance(service.classLoader, arrayOf(service), ProxyHandler()) as T


        //kotlin语法约定，如果lambda表达式是函数是最后一个实参的话，它可以放在括号外面
//        return Proxy.newProxyInstance(
//            service.classLoader, arrayOf(service)
//        ) { _, method, _ ->
//            //解析注解
//            val annotations = method.annotations
//            if (annotations.isEmpty()) {
//                throw IllegalStateException("annotation required.")
//            }
//            annotations.forEach {
//                Logger.d(it.toString())
//                Logger.d(it is GET)
//                return@newProxyInstance when (it) {
//                    is GET -> {
//                        handlerGet(it.value)
//                    }
//                    is POST -> {
//                        //不处理，只模拟GET
//                    }
//                    else -> {
//
//                    }
//                }
//            }
//        } as T
    }

    inner class ProxyHandler : InvocationHandler {

        override fun invoke(proxy: Any, method: Method, args: Array<out Any>): Any {
            //解析注解
            val annotations = method.annotations
            if (annotations.isEmpty()) {
                throw IllegalStateException("annotation required.")
            }
            return annotations.forEach {
                Logger.d(it.toString())
                Logger.d(it is GET)
                when (it) {
                    is GET -> {
                        handlerGet(it.value)
                    }
                    is POST -> {
                        //这里其实得有body
                        handlerPost(it.value)
                    }
                    else -> {
                        //抛个异常
                        throw Exception("只支持get和post")
                    }
                }
            }
        }

    }

    /**
     * 处理get请求
     */
    private fun handlerGet(url: String): Call {
        val request = Request.Builder()
            .url(baseUrl + url)
            .get()
            .build()
        //这里没有做返回类型转换，默认都返回call
        return callFactory.newCall(request)
    }

    private fun handlerPost(url: String): Call {
        val request = Request
            .Builder()
            .url(baseUrl + url)
            //.post()
            .build()
        return callFactory.newCall(request)
    }


    class Builder {
        private var baseUrl: String? = null
        private var callFactory: Call.Factory? = null

        /**
         * 模拟传入baseUrl
         */
        fun baseUrl(baseUrl: String): Builder {
            this.baseUrl = baseUrl
            return this
        }

        /**
         * 模拟传入client
         */
        fun client(client: OkHttpClient): Builder {
            this.callFactory = client
            return this
        }

        fun build(): Retrofit {
            if (baseUrl == null) {
                throw IllegalStateException("Base URL required.")
            }
            if (callFactory == null) {
                callFactory = OkHttpClient()
            }
            return Retrofit(callFactory!!, baseUrl!!)
        }
    }
}