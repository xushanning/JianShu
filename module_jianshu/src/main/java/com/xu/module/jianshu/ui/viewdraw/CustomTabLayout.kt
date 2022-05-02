package com.xu.module.jianshu.ui.viewdraw

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import com.google.android.material.tabs.TabLayout
import com.orhanobut.logger.Logger

/**
 * @author 许 on 2021/12/19.
 */
class CustomTabLayout(context: Context, attrs: AttributeSet?) : TabLayout(context, attrs) {


    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Logger.d("tablayout dispatchTouchEvent")
        return super.dispatchTouchEvent(ev)
    }
}