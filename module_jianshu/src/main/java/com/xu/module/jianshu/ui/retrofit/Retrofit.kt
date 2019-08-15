package com.xu.module.jianshu.ui.retrofit

import com.orhanobut.logger.Logger
import okhttp3.*
import java.lang.reflect.Proxy

/**
 * @author 言吾許
 * 模拟retrofit实现过程
 */
@Suppress("UNCHECKED_CAST")
class Retrofit(var callFactory: Call.Factory, var baseUrl: HttpUrl) {


    fun <T> create(service: Class<T>): T {
        return Proxy.newProxyInstance(
            service.classLoader, arrayOf(service)
        ) { _, method, args ->
            //真正的retrofit会把网络请求逻辑放在其他类中处理

            //解析注解
            val annotations = method.annotations
            if (annotations.isEmpty()) {
                throw IllegalStateException("annotation required.")
            }

            //判断post get等
            val netType = annotations[0].toString()
            annotations.forEach {
                when (it) {
                    GET::class.java -> {
                        it as GET
                        Logger.d(it.value)
                    }
                    POST::class.java -> {
                        it as POST
                        Logger.d(it.value)
                    }
                }
            }

            Logger.d(netType)
            // 解析参数 args
            args.forEach {
                Logger.d(it)
            }


            val body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "")
            //写死的post
            val request = Request.Builder()
                .url(baseUrl)
                .post(body)
                .build()
            callFactory.newCall(request)
        } as T
    }


    class Builder {
        private var baseUrl: HttpUrl? = null
        private var callFactory: Call.Factory? = null
        /**
         * 模拟传入baseUrl
         */
        fun baseUrl(baseUrl: String): Builder {
            this.baseUrl = HttpUrl.parse(baseUrl)
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