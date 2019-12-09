package com.xu.module.jianshu.ui.coordinatorlayout.sample1

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.orhanobut.logger.Logger


class TextViewBehavior(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<TextView>(context, attrs) {
    /**
     * 界面整体向上滑动，达到列表可滑动的临界点
     */
    private var upReach = false

    /**
     * textview露出来后，再向下滑动，达到界面整体可滑动的临界点
     */
    private var downReach = false
    /**
     * 列表上一个全部可见的item位置
     */
    private var lastPosition = -1


    /**
     * 是否拦截触摸事件
     * 回调机制：
     * https://blog.csdn.net/lisdye2/article/details/78344030
     * 遍历所有的behavior, 按照顺序执行onInterceptTouchEvent()
     * 如果其中一个behhavior的onInterceptTouchEvent()返回true
     * 如果当前事件是ACTION_DOWN:则后面的behavior的onIntercepTouchEvent()就不会被回调
     * 如果当前事件是其他事件，则后面会被收到一个ACTION_CANCEL 事件
     */
    override fun onInterceptTouchEvent(parent: CoordinatorLayout, child: TextView, ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) {
            //只要一按下，就恢复成false
            downReach = false
            upReach = false
        }
        return super.onInterceptTouchEvent(parent, child, ev)
    }

    /**
     * 嵌套滑动开始（ACTION_DOWN），确定Behavior是否要监听此次事件
     * 返回true则监听此嵌套滚动
     * 这里只监听垂直的滚动事件
     */
    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: TextView, directTargetChild: View, target: View, axes: Int, type: Int): Boolean {
        //垂直
        return axes and ViewCompat.SCROLL_AXIS_VERTICAL != 0
    }

    /**
     * 嵌套滑动进行中，要监听的子 View将要滑动，滑动事件即将被消费（但最终被谁消费，可以通过代码控制）
     * @param dx 子view在水平方向上移动的像素数
     * @param dy 子view在垂直方向上移动的的像素数 网上的时候是正的，往下是负的 我当到临界点的时候，开始线性变大,为什么呢？因为 consumed[1] = dy 这个dy被消费了，
     * 类似于，按照滑动，这个view应该滑动了dy的距离，但是由于不让滑动，卡主
     *@param consumed consumed[0]消耗的dx的距离 consumed[1]消耗的dy的距离
     */
    override fun onNestedPreScroll(coordinatorLayout: CoordinatorLayout, child: TextView, target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)

        if (target is RecyclerView) {
            //列表第一个全部可见Item的位置
            val position = (target.layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()
            //满足达到往下滑动的临界点的条件是：①完全可见的item位置为0，很好理解
            //②上一个位置大于0，为什么这样？表示正在从上往下滑动，才会出现>0的情况
            if (position == 0 && lastPosition > 0) {
                downReach = true
            }
            //Logger.d(dy)
//            Logger.d(lastPosition)
//            Logger.d(downReach)
            Logger.d(canScroll(child, dy))
            /**
             * 整体可以滑动，否则RecyclerView消费滑动事件
             *滑动情况记录：首先是全部展现，手指放在recyclerview上，开始往上面移动，canScroll=true，代表事件没有被recyclerview消费，
             * 当前是coordinator整体滑动，滑动到textview正好消失那个点，canScroll还是true，但是这个时候已经滑动不了了，抬起手指，再次按下
             * 往上滑动，recyclerView开始可以滑动，这时候canScroll=false，代表recyclerView消费了胡奥定事件，不是coordinator滑动
             * 下滑，canScroll=false，滑动到textview要出来的哪个点，状态不变，划不动了，然后抬起手指，再次按下，接着下滑，canScroll=true
             *
             *
             *
             * 所以，一次性的按下后，上滑或者下滑，到textview出现或者隐藏点的时候，不能继续滑动，就是因为此时整体是coordinator在消费事件
             * 还是recyclerview在消费事件！！！！
             * 只有在position为0的时候，才切换状态
             */
            if (canScroll(child, dy) && position == 0) {
                var finalY = child.translationY - dy
                if (finalY < -child.height) {
                    finalY = -child.height.toFloat()
                    upReach = true
                } else if (finalY > 0) {
                    finalY = 0f
                }
                child.translationY = finalY
                //让CoordinatorLayout消费滑动事件
                consumed[1] = dy
            }
            lastPosition = position
        }
    }

    /**
     * 整体是否可以滑动
     * 不能整体滑动有两种情况:
     */
    private fun canScroll(child: View, scrollY: Int): Boolean {
//        Logger.d(scrollY)
//        Logger.d(child.translationY)
//        Logger.d(child.height.toFloat())
        //上滑临界点:因为第一个完全漏出来的position永远是0，因此不能像判断downReach 一样去判断upReach
        //因此满足条件scrollY>0代表手指（或者说view）正在往上滑动
        // child.translationY代表和初始状态（textview全部显示）的偏移量正好等于textview的距离，也就是说正好隐藏，!upReach  代表没有到临界点

        if (scrollY > 0 && child.translationY == -child.height.toFloat() && !upReach) {
            return false
        }
        //下滑临界点:从上往下滑，到达临界点的时候，就禁止整体滑动，判断downReach参数
        if (downReach) {
            return false
        }
        return true
    }


}