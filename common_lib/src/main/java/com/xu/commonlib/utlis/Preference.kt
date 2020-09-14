package com.xu.commonlib.utlis

import android.content.Context
import com.xu.commonlib.base.BaseApplication

import kotlin.reflect.KProperty

/**
 * @author 言吾許
 */

class Preference<T>(private val key: String, private val default: T) {
    private val fileName: String = "xiang_tang_data"
    private val prefs by lazy {
        BaseApplication.appContext.getSharedPreferences(fileName, Context.MODE_PRIVATE)
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putSharePreferences(key, value)
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return getSharePreferences(key, default)
    }

    /**
     * 存share数据
     * @param key key值
     * @param data object类型数据
     */
    fun putSharePreferences(key: String, data: T) = with(prefs.edit()) {
        when (data) {
            is String -> {
                putString(key, data)
            }
            is Long -> {
                putLong(key, data)
            }
            is Int -> {
                putInt(key, data)
            }
            is Float -> {
                putFloat(key, data)
            }
            is Boolean -> {
                putBoolean(key, data)
            }
            else -> throw IllegalArgumentException("不能被保存的类型！")
        }.apply()
    }

    @Suppress("UNCHECKED_CAST")
    fun getSharePreferences(key: String, default: T): T = with(prefs) {
        return when (default) {
            is String -> {
                getString(key, default)
            }
            is Long -> {
                getLong(key, default)
            }
            is Float -> {
                getFloat(key, default)
            }
            is Int -> {
                getInt(key, default)
            }
            is Boolean -> {
                getBoolean(key, default)
            }
            else -> throw IllegalArgumentException("不能获取的类型!")
        } as T
    }
}