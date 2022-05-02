package com.xu.module.jianshu.ui.viewdrag

import android.view.View
import androidx.customview.widget.ViewDragHelper
import kotlin.math.max
import kotlin.math.min

/**
 * @author 许 on 2021/12/11.
 * 只让view在ViewGroup中移动
 * */
class InnerCallback(private val parentView: View) : ViewDragHelper.Callback() {
    //返回true，表示可以
    override fun tryCaptureView(child: View, pointerId: Int): Boolean {
        return true
    }

    /**
     * @param left 子view将要达到的达到的水平方向的距离
     * @return view的边界控制，如果返回0那么就不能拖动了
     * 比如如果我想让view只能在viewgroup内部拖动话，可以如下写法
     */
    override fun clampViewPositionHorizontal(child: View, left: Int, dx: Int): Int {
        val rightBound = parentView.width - child.width
        //左边界不能小于0，有边界不能大于父view的宽度减去子view的宽度
        return min(max(0, left), rightBound)
    }

    override fun clampViewPositionVertical(child: View, top: Int, dy: Int): Int {
        return top
    }
}