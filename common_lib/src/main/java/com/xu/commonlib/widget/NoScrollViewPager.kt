package com.xu.commonlib.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

/**
 * @author 言吾許
 * 禁止滑动和滑动动画
 */
class NoScrollViewPager : ViewPager {
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context) : super(context)

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return false
    }


    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return true
    }

    override fun setCurrentItem(item: Int) {
        super.setCurrentItem(item, false)
    }

}

