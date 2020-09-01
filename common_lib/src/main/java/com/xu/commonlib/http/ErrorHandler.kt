package com.xu.commonlib.http

import retrofit2.HttpException

/**
 * 处理异常
 */
object ErrorHandler {
    fun handleError(e: Throwable): ApiException {
        return when (e) {
            is ApiException -> e
            is HttpException -> ApiException("", e.message)
            else -> ApiException("", e.message)
        }
    }
}