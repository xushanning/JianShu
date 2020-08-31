package com.xu.commonlib.http

/**
 * 返回基类
 */
abstract class BaseRes<T> {
    abstract fun isSuccess(): Boolean

    abstract fun getResData(): T

    abstract fun getResCode(): Int

    abstract fun getResMsg(): String

}