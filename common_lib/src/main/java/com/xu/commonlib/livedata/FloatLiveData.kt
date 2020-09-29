package com.xu.commonlib.livedata

import androidx.lifecycle.MutableLiveData

class FloatLiveData(private val default: Float = 0f) : MutableLiveData<Float>() {
    override fun getValue(): Float {
        return super.getValue() ?: default
    }
}