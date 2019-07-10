package com.xu.commonlib.utlis.extention

import com.google.android.material.tabs.TabLayout

/**
 * @author 言吾許
 * tabLayout扩展
 */

fun <T : TabLayout> T.tabSelected(block: (position: Int) -> Unit) {
    addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
        override fun onTabReselected(p0: TabLayout.Tab?) {

        }

        override fun onTabUnselected(p0: TabLayout.Tab?) {
        }

        override fun onTabSelected(p0: TabLayout.Tab) {
            block(p0.position)
        }

    })

}