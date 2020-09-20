package com.xu.commonlib.livedata

import androidx.lifecycle.MutableLiveData

class BooleanLiveData(private val default: Boolean = false) : MutableLiveData<Boolean>() {
    override fun getValue(): Boolean {
        return super.getValue() ?: default
    }
}