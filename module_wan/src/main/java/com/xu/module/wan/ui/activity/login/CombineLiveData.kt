package com.xu.module.wan.ui.activity.login

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData

class CombineLiveData<T1, T2, R>(source1: MutableLiveData<T1>, source2: MutableLiveData<T2>, combiner: (T1, T2) -> R) :
    MediatorLiveData<R>() {
    init {
        addSource(source1) {
            value = combiner(it, source2.value!!)
        }

        addSource(source2) {
            value = combiner(source1.value!!, it)
        }
    }
}