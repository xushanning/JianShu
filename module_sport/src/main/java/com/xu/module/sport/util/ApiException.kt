package com.xu.module.sport.util

/**
 * @author 言吾許
 */
class ApiException : Exception {
    var code: Int = 0

    constructor(message: String) : super(message)

    constructor(message: String, code: Int) : super(message) {
        this.code = code
    }

    companion object {


    }

}