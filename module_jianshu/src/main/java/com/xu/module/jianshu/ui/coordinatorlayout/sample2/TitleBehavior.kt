package com.xu.module.jianshu.ui.coordinatorlayout.sample2

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.RecyclerView
import com.orhanobut.logger.Logger

/**
 * @author 许
 */
class TitleBehavior(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<TextView>(context, attrs) {
    private var distance = 0f

    //依赖recyclerView
    override fun layoutDependsOn(parent: CoordinatorLayout, child: TextView, dependency: View): Boolean {
        return dependency is RecyclerView
    }


    override fun onDependentViewChanged(parent: CoordinatorLayout, child: TextView, dependency: View): Boolean {

        if (distance == 0f) {
            //初始化  列表顶部和title底部重合时，列表的滑动距离
            distance = (dependency.top - child.height).toFloat()
        }

        //recyclerview和textview之间的距离（运动中的），如果两个距离变成负数，那么说明已经交汇了
        val dy = if (dependency.top - child.height < 0) {
            0f
        } else {
            (dependency.top - child.height).toFloat()
        }
        //往上推的时候，textview的y是从负的它的高度，慢慢变为0，所以刚打开这个页面的时候，y=-131（高度）
        val y = -(dy / distance) * child.height
        Logger.d(y)
        child.translationY = y
        return true
    }

}