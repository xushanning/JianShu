package com.xu.module.jianshu.ui.coordinatorlayout.zhifubao

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.RecyclerView
import com.orhanobut.logger.Logger
import com.xu.module.jianshu.R

class ToolBarBehavior(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<Toolbar>(context, attrs) {
    private var halfDistance = 0f
    private var cl1: ConstraintLayout? = null
    private var cl2: ConstraintLayout? = null
    private var vBg1: View? = null
    private var vBg2: View? = null
    override fun layoutDependsOn(parent: CoordinatorLayout, child: Toolbar, dependency: View): Boolean {
        return dependency is RecyclerView
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout, child: Toolbar, dependency: View): Boolean {
        Logger.d(dependency.top)
        if(dependency is RecyclerView){
            if (cl1 == null) {
                cl1 = child.findViewById(R.id.cl_1)
                cl2 = child.findViewById(R.id.cl_2)
                vBg1 = child.findViewById(R.id.v_bg1)
                vBg2 = child.findViewById(R.id.v_bg2)
            }
            if (halfDistance == 0f) {
                halfDistance = dependency.top.toFloat() / 2
            }

            if (dependency.top.toFloat() / halfDistance <= 1f) {
                cl1?.visibility = View.GONE
                cl2?.visibility = View.VISIBLE
                val scale = (halfDistance - dependency.top) / (halfDistance)
                val alpha = (255 * (1 - scale)).toInt()
                Logger.d("透明度$alpha")
                vBg2?.setBackgroundColor(Color.argb(alpha, 25, 131, 209))
            } else {
                cl2?.visibility = View.GONE
                cl1?.visibility = View.VISIBLE
                val scale = (dependency.top - halfDistance) / (halfDistance)
                val alpha = (255 * (1 - scale)).toInt()
                vBg1?.setBackgroundColor(Color.argb(alpha, 25, 131, 209))
            }
        }

        return true
    }

}