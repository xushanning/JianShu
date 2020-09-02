package com.xu.commonlib.http

class ApiException : Exception {

    var errorCode = 0
    var errorMsg: String
    var errorLog: String?

    constructor(errorCode: Int, errorMsg: String?, errorLog: String?) : super(errorMsg) {
        this.errorCode = errorCode
        this.errorMsg = errorMsg ?: "请求失败，请稍后再试"
        this.errorLog = errorLog
    }

    constructor(errorMsg: String?, errorLog: String?) : super(errorMsg) {
        this.errorMsg = errorMsg ?: "请求失败，请稍后再试"
        this.errorLog = errorLog
    }

}