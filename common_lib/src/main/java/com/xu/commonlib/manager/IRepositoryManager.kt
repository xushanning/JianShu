package com.xu.commonlib.manager

/**
 * @author 言吾許
 */
interface IRepositoryManager {

    /**
     * 根据传入的class不同，获取不同的retrofit 客户端
     */
    fun <T> obtainRetrofitService(service: Class<T>): T
}