package com.xu.module.jianshu.ui.nestedscroll

import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import androidx.core.view.NestedScrollingParent2
import androidx.core.view.NestedScrollingParentHelper
import androidx.core.view.ViewCompat
import com.orhanobut.logger.Logger
import com.xu.module.jianshu.R
import kotlin.math.abs
import kotlin.math.roundToInt


/**
 * 父view
 */
class ParentView : LinearLayout, NestedScrollingParent2 {

    private lateinit var mNestedScrollingParentHelper: NestedScrollingParentHelper
    /**
     * title view的高度
     */
    private var mTitleViewHeight = 0
    /**
     * title  view
     */
    private lateinit var mTitleView: View
    /**
     * 头部图片高度
     */
    private var mHeadViewHeight = 0
    /**
     * 头部图片
     */
    private lateinit var mHeadView: ImageView
    /**
     * listview
     */
    private lateinit var mList: ListView
    /**
     * 动画用于处理fling
     */
    private var mValueAnimator: ValueAnimator? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        orientation = VERTICAL
        mNestedScrollingParentHelper = NestedScrollingParentHelper(this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        mTitleView = findViewById(R.id.tv_title)
        mHeadView = findViewById(R.id.img_head)
        mList = findViewById(R.id.list)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        //先测量一次
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        //重新设置了listview的高度必须重新计算listview的高度，否则会出现留白,相当于，listview的高度等于整个页面的高度减去titleView的高度，这样，
        //初始化的时候，listview其实有一部分在屏幕下面，等到划到顶部的时候，正好底部位于屏幕最下面
        val layoutParams = mList.layoutParams
        layoutParams.height = measuredHeight - mTitleView.measuredHeight
        mList.layoutParams = layoutParams
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    /**
     * 有嵌套滑动到来了，判断父控件是否接收嵌套滑动
     * @param child 嵌套滑动对应的父类的子类(因为嵌套滑动对于的父控件不一定是一级就能找到的，可能挑了两级父控件的父控件，child的辈分>=target)
     * @param target  具体嵌套滑动的那个子类
     *@param axes 支持嵌套滚动轴。水平方向，垂直方向，或者不指定
     * @return 父控件是否接受嵌套滑动 只有返回true才能执行下面的嵌套滑动
     *这里只处理垂直方向的
     */
    override fun onStartNestedScroll(child: View, target: View, axes: Int, type: Int): Boolean {
        // Logger.d("onStartNestedScroll")
        return (axes and ViewCompat.SCROLL_AXIS_VERTICAL) != 0
    }

    override fun onStartNestedScroll(child: View, target: View, axes: Int): Boolean {
        return (axes and ViewCompat.SCROLL_AXIS_VERTICAL) != 0
    }

    /**
     * 只有当onStartNestedScroll的时候，才会调用这个方法
     */
    override fun onNestedScrollAccepted(child: View, target: View, axes: Int, type: Int) {
        //Logger.d("onNestedScrollAccepted")
        mNestedScrollingParentHelper.onNestedScrollAccepted(child, target, axes, type)
    }

    override fun onNestedScrollAccepted(child: View, target: View, axes: Int) {
        mNestedScrollingParentHelper.onNestedScrollAccepted(child, target, axes)
    }


    /**
     * 返回当前父控件嵌套滑动的方向，分为水平方向与，垂直方法，或者不变
     */
    override fun getNestedScrollAxes(): Int {
        return mNestedScrollingParentHelper.nestedScrollAxes
    }

    /**
     * 在嵌套的子控件未滑动之前调用，判断父控件是否优先于子控件处理
     * @param target 嵌套滑动的子类
     * @param dx 水平方向嵌套的子控件 想要 变化的距离 dx<0向右滑动 dx>0向左滑动
     * @param dy 垂直方向嵌套的子控件 想要 变化的距离 dy<0向下滑动 dy>0向上滑动
     * @param consumed 父控件告诉子控件消耗的距离，consumed[0]水平消耗的距离 consumed[1]垂直消耗的距离
     */
    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
//        Logger.d("子控件想要滑动的距离$dy==$scrollY")
        //是否隐藏顶部的图片需要满足两个条件：①子view想向上滑动（dy > 0）②父容器整体滑动的距离小于图片的高度
        val hideTop = dy > 0 && scrollY < mHeadViewHeight
        //是否展示已经隐藏的顶部图片需要满足以下条件：
        //①子view想向下滑动(dy<0)
        //②整体的父容器，有部分是在屏幕top之上的（scrollY >= 0）
        //③子view能否往下滚动，首先允许子view往下滚动，当不能往下滚动的时候，再让父容器往下滚动，正数为是否能往上滚动 负数为是否能往下滚动
        val showTop = dy < 0 && scrollY >= 0 && !target.canScrollVertically(-1)
//        Logger.d(dy)
//        Logger.d(scrollY)
//        Logger.d(showTop)
//        Logger.d(target.canScrollVertically(-1))
        if (hideTop || showTop) {
            //整体滑动dy的距离
            scrollBy(0, dy)
            //父view要消耗掉dy的距离，如果不消耗，会发现，整体往上滑动，listview也往上滑动
            consumed[1] = dy
        }

    }

    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray) {
    }

    /**
     * 嵌套滑动的子控件在滑动之后，判断父控件是否继续处理（也就是父消耗一定距离后，子再消耗，最后判断父消耗不）
     * @param target       具体嵌套滑动的那个子类
     * @param dxConsumed   水平方向嵌套滑动的子控件滑动的距离(消耗的距离)
     * @param dyConsumed   垂直方向嵌套滑动的子控件滑动的距离(消耗的距离)
     * @param dxUnconsumed 水平方向嵌套滑动的子控件未滑动的距离(未消耗的距离)
     * @param dyUnconsumed 垂直方向嵌套滑动的子控件未滑动的距离(未消耗的距离)
     */
    override fun onNestedScroll(target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int) {
    }

    override fun onNestedScroll(target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int) {
    }

    /**
     *  当子控件产生fling滑动时，判断父控件是否处拦截fling，如果父控件处理了fling，那子控件就没有办法处理fling了。
     *  @param target    具体嵌套滑动的那个子类
     *  @param velocityX 水平方向上的速度 velocityX > 0  向左滑动，反之向右滑动
     *  @param velocityY 竖直方向上的速度 velocityY > 0  向上滑动，反之向下滑动
     *  @return 父控件是否拦截该fling
     *  为了让子控件也能处理fling，一定要返回false，如果返回了true，那么父控件就拦截了，子控件就没机会处理fling了
     */
    override fun onNestedPreFling(target: View, velocityX: Float, velocityY: Float): Boolean {
        Logger.d("onNestedPreFling")
        return false
    }

    /**
     *当父控件不拦截该fling,那么子控件会将fling传入父控件
     * @param target    具体嵌套滑动的那个子类
     * @param velocityX 水平方向上的速度 velocityX > 0  向左滑动，反之向右滑动
     * @param velocityY 竖直方向上的速度 velocityY > 0  向上滑动，反之向下滑动
     * @param consumed  子控件是否可以消耗该fling，也可以说是子控件是否消耗掉了该fling
     * @return 父控件是否消耗了该fling
     */
    override fun onNestedFling(target: View, velocityX: Float, velocityY: Float, consumed: Boolean): Boolean {
        Logger.d("onNestedFling")
        val distance = abs(scrollY)
        val duration: Int
        if (velocityY > 0) {
            //往上滑
            duration = (1000 * (distance / velocityY)).roundToInt()
            startAnimation(duration, scrollY, mHeadViewHeight)
        } else if (velocityY < 0) {
            val distanceRatio = (distance.toFloat()) / height
            duration = ((distanceRatio + 1) * 150).toInt()
            startAnimation(duration, scrollY, 0)
        }

        return true
    }

    /**
     * 嵌套滑动结束
     */
    override fun onStopNestedScroll(target: View, type: Int) {
        mNestedScrollingParentHelper.onStopNestedScroll(target, type)
    }

    override fun onStopNestedScroll(target: View) {
        mNestedScrollingParentHelper.onStopNestedScroll(target)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mTitleViewHeight = mTitleView.measuredHeight
        mHeadViewHeight = mHeadView.measuredHeight
    }

    private fun startAnimation(duration: Int, startY: Int, endY: Int) {
        if (mValueAnimator == null) {
            mValueAnimator = ValueAnimator()
            mValueAnimator?.addUpdateListener {
                val animatedValue = (it.animatedValue) as Int
                scrollTo(0, animatedValue)
            }
        } else {
            mValueAnimator?.cancel()
        }
        mValueAnimator?.interpolator = DecelerateInterpolator()
        mValueAnimator?.setIntValues(startY, endY)
        mValueAnimator?.duration = duration.toLong()
        mValueAnimator?.start()
    }

    override fun scrollTo(x: Int, y: Int) {
        var resultY = y
        if (y < 0) {
            resultY = 0
        }
        if (y > mHeadViewHeight) {
            resultY = mHeadViewHeight
        }
        super.scrollTo(x, resultY)
    }
}