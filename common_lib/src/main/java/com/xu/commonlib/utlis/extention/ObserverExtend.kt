package com.xu.commonlib.utlis.extention

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

/**
 * LifecycleOwner扩展
 */
fun <T> LifecycleOwner.observe(liveData: LiveData<T>, observer: (t: T) -> Unit) {
    liveData.observe(this) {
        observer(it)
    }
}

/**
 * paging的扩展
 */
fun <T : Any, VH : RecyclerView.ViewHolder> LifecycleOwner.observe(pagingAdapter: PagingDataAdapter<T, VH>, liveData: LiveData<PagingData<T>>) {
    liveData.observe(this) {
        lifecycleScope.launch {
            pagingAdapter.submitData(it)
        }
    }
}