package com.xu.module.jianshu.ui.viewdraw

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.BaseActivity
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.module.jianshu.R
import kotlinx.android.synthetic.main.j_activity_view_draw.*

/**
 * view绘制测试
 */
class ViewDrawActivity : BaseActivity() {
    override fun setLayoutId(): Int {
        return R.layout.j_activity_view_draw
    }


//    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
//        val y = ev.y
//        return when (ev.action) {
//            MotionEvent.ACTION_MOVE -> {
//                v_parent.dispatchTouchEvent(ev)
//            }
//            else -> {
//                super.dispatchTouchEvent(ev)
//            }
//        }
//    }

    override fun initView(savedInstanceState: Bundle?) {

        v_parent.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Logger.d("onTabSelected")
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Logger.d("onTabUnselected")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Logger.d("onTabReselected")
            }

        })
    }

    override fun initData() {
    }
}