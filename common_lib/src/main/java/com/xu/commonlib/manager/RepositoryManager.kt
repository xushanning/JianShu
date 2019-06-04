package com.xu.commonlib.manager

import javax.inject.Inject

/**
 * @author 言吾許
 */
class RepositoryManager @Inject constructor() : IRepositoryManager {

    override fun <T> obtainRetrofitService(service: Class<T>): T {
        return null!!
//        return createRetrofitService(service)
    }


//    private fun <T> createRetrofitService(serviceClass: Class<T>): T {
//        return Proxy.newProxyInstance(
//            serviceClass.classLoader,
//            arrayOf<Class<*>>(serviceClass)
//        ) { proxy, method, args ->
//            if (method.returnType == Observable::class.java) {
//                Observable.defer {
//
//                }
//            } else {
//
//            }
//
//        } as T
//    }
//
//    private fun <T> getRetrofitService(serviceClass: Class<T>) {
//
//    }


}