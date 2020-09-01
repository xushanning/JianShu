package com.xu.commonlib.http

/**
 * 返回基类
 */
abstract class BaseResponse<T> {
    abstract fun isSuccess(): Boolean

    abstract fun getResData(): T

    abstract fun getResCode(): Int

    abstract fun getResMsg(): String

}