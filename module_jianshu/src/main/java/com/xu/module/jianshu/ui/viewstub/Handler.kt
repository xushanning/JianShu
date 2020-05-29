package com.xu.module.jianshu.ui.viewstub

/**
 * @author 许 on 2020/5/29.
 */
open class Handler {
    private var msgLocal: String? = null

    fun sendMessage(msg: String) {
        this.msgLocal = msg
        handleMessage(msgLocal!!)
    }

    @Synchronized
    open fun handleMessage(msg: String) {

    }
}