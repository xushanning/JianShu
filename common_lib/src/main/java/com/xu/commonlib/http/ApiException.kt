package com.xu.commonlib.http

class ApiException(var errCode: Int, error: String?) : Exception(error) {
    var errorMsg: String = error ?: "请求失败，请稍后再试"
}