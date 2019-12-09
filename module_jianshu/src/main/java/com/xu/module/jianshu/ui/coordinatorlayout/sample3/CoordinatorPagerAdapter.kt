package com.xu.module.jianshu.ui.coordinatorlayout.sample3

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * @author xu
 */
class CoordinatorPagerAdapter constructor(fm: FragmentManager, private val fragmentList: List<Fragment>, private val titleList: List<String>) :
        FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }
}