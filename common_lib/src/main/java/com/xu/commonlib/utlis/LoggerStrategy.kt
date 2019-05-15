package com.xu.commonlib.utlis

import android.util.Log
import com.orhanobut.logger.LogStrategy

/**
 * @author 言吾許
 */
class LoggerStrategy : LogStrategy {
    private var last: Int = 0
    override fun log(priority: Int, tag: String?, message: String) {
        Log.println(priority, randomKey() + tag, message)
    }

    private fun randomKey(): String {
        var random: Int = 10 * Math.random().toInt()
        if (random == last) {
            random = (random + 1) % 10
        }
        last = random
        return random.toString()
    }
}