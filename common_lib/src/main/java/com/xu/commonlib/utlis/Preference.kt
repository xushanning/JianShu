package com.xu.commonlib.utlis

import com.tencent.mmkv.MMKV

import kotlin.reflect.KProperty

/**
 * @author 言吾許
 */

class Preference<T>(private val key: String, private val default: T) {
    private val kv by lazy {
        MMKV.defaultMMKV()
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
    private fun putSharePreferences(key: String, data: T) = with(kv) {
        when (data) {
            is String -> {
                encode(key, data)
            }
            is Long -> {
                encode(key, data)
            }
            is Int -> {
                encode(key, data)
            }
            is Float -> {
                encode(key, data)
            }
            is Boolean -> {
                encode(key, data)
            }
            else -> throw IllegalArgumentException("不能被保存的类型！")
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun getSharePreferences(key: String, default: T): T = with(kv) {
        return when (default) {
            is String -> {
                decodeString(key, default)
            }
            is Long -> {
                decodeLong(key, default)
            }
            is Float -> {
                decodeFloat(key, default)
            }
            is Int -> {
                decodeInt(key, default)
            }
            is Boolean -> {
                decodeBool(key, default)
            }
            else -> throw IllegalArgumentException("不能获取的类型!")
        } as T
    }
}