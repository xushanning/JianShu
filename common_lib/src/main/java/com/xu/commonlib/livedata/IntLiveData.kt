package com.xu.commonlib.livedata

import androidx.lifecycle.MutableLiveData

class IntLiveData(private val default: Int = 0) : MutableLiveData<Int>() {
    override fun getValue(): Int {
        return super.getValue() ?: default
    }
}