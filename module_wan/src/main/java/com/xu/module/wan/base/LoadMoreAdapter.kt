package com.xu.module.wan.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.orhanobut.logger.Logger
import com.xu.module.wan.R

class LoadMoreAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<LoadMoreAdapter.LoadMoreViewHolder>() {

    override fun onBindViewHolder(holder: LoadMoreViewHolder, loadState: LoadState) {
        holder.changeState(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadMoreViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.w_view_load_more_footer, parent, false)
        return LoadMoreViewHolder(view) { retry() }
    }

    class LoadMoreViewHolder(view: View, private val retry: () -> Unit) :
        RecyclerView.ViewHolder(view) {
        private val tvContent = view.findViewById<TextView>(R.id.tv_load_more)
        private val pbLoadMore = view.findViewById<ProgressBar>(R.id.pb_load_more)
        private val tvRetry = view.findViewById<TextView>(R.id.tv_retry).also {
            it.setOnClickListener {
                retry()
            }
        }

        fun changeState(loadState: LoadState) {
            pbLoadMore.isVisible = loadState is LoadState.Loading
            tvContent.isVisible = loadState is LoadState.Loading
            tvRetry.isVisible = loadState is LoadState.Error

        }
    }
}