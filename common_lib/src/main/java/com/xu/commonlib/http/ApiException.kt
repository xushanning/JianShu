package com.xu.commonlib.http

class ApiException : Exception {
    //  var errorMsg: String = error ?:
    private var errorCode = 0
    private var errorMsg: String
    private var errorLog: String?

    constructor(errorCode: Int, errorMsg: String, errorLog: String?) : super(errorMsg) {
        this.errorCode = errorCode
        this.errorMsg = errorMsg ?: "请求失败，请稍后再试"
        this.errorLog = errorLog
    }

    constructor(errorMsg: String, errorLog: String?) : super(errorMsg) {
        this.errorMsg = errorMsg
        this.errorLog = errorLog
    }

}