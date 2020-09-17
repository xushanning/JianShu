package com.xu.module.wan.utils.ext

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * float button初始化
 */
fun RecyclerView.initFloatButton(bt: FloatingActionButton) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            if (!canScrollVertically(-1)) {
                bt.visibility = View.INVISIBLE
            }
        }
    })
    bt.setOnClickListener {
        val manager = layoutManager as LinearLayoutManager
        if (manager.findLastVisibleItemPosition() >= 40) {
            scrollToPosition(0)
        } else {
            smoothScrollToPosition(0)
        }
    }
}