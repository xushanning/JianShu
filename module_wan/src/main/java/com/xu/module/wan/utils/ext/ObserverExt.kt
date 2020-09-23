package com.xu.module.wan.utils.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.xu.module.wan.bean.base.BasePageResBean
import com.xu.module.wan.bean.base.BaseResBean
import kotlinx.coroutines.launch


fun <T : Any, VH : RecyclerView.ViewHolder> LifecycleOwner.observer(pagingAdapter: PagingDataAdapter<T, VH>, source: suspend (Int) -> BaseResBean<BasePageResBean<MutableList<T>>>) {
    createPager { source.invoke(it) }.observe(this) {
        lifecycleScope.launch {
            pagingAdapter.submitData(it)
        }
    }
}