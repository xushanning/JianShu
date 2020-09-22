package com.xu.module.wan.utils.ext

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.w_activity_collect_history.*

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

/**
 * 初始化ViewPager
 */
fun ViewPager2.init(activity: FragmentActivity, tabLayout: TabLayout, fragments: List<Fragment>, tabNames: List<String>) {
    adapter = object : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int {
            return fragments.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragments[position]
        }

    }
    TabLayoutMediator(tabLayout, this) { tab, position ->
        tab.text = tabNames[position]
    }.attach()
}

fun ViewPager2.init(fragment: Fragment, tabLayout: TabLayout, fragments: List<Fragment>, tabNames: List<String>) {
    adapter = object : FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int {
            return fragments.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragments[position]
        }

    }
    TabLayoutMediator(tabLayout, this) { tab, position ->
        tab.text = tabNames[position]
    }.attach()
}