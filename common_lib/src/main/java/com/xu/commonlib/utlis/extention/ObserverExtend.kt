package com.xu.commonlib.utlis.extention

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.observe

/**
 * LifecycleOwner扩展
 */
fun <T> LifecycleOwner.observe(liveData: LiveData<T>, observer: (t: T) -> Unit) {
    liveData.observe(this) {
        observer(it)
    }
}