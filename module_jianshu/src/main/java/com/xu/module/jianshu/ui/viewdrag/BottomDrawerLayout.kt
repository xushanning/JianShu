package com.xu.module.jianshu.ui.viewdrag

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import androidx.customview.widget.ViewDragHelper
import com.app.hubert.guide.util.LogUtil
import com.orhanobut.logger.Logger
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.module.jianshu.R
import kotlin.math.max
import kotlin.math.min

/**
 * @author 许 on 2021/12/11.
 */
class BottomDrawerLayout(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    private lateinit var drag: ViewDragHelper

    private lateinit var view: View

    private var x: Int = 0
    private var y: Int = 0

    private var view1Height: Int = 0

    init {
        drag = ViewDragHelper.create(this, 1.0f, object : ViewDragHelper.Callback() {
            override fun tryCaptureView(child: View, pointerId: Int): Boolean {
                return child == view
            }

            override fun clampViewPositionVertical(child: View, top: Int, dy: Int): Int {
                //将可滑动范围限定在0~height-150之间
                return min(max(0, top), height - 150)
            }

            override fun onViewReleased(releasedChild: View, xvel: Float, yvel: Float) {
                if (releasedChild.y > 500) {
                    drag.settleCapturedViewAt(0, height - 150)
                } else {
                    drag.settleCapturedViewAt(0, 0)
                }

                invalidate()
            }
        })
    }


    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return drag.shouldInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                Logger.d("2222的ACTION_DOWN事件")
            }
            MotionEvent.ACTION_MOVE -> {
                Logger.d("2222的ACTION_MOVE事件")
            }
            MotionEvent.ACTION_UP -> {
                Logger.d("2222的ACTION_UP事件")
            }
        }
        drag.processTouchEvent(event)


        return true
    }

    override fun computeScroll() {
        if (drag.continueSettling(true)) {
            invalidate()
        } else {
            x = view.left;
            y = view.top;
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        Logger.d("====" + view1Height)
        view.layout(x, y - view1Height, x + view.measuredWidth, y + view.measuredHeight)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        val view1: View = findViewById(R.id.view1)
        view1.setOnTouchListener { v, event ->
            Logger.d("ontouch")
            return@setOnTouchListener false
        }
        //        view1.setOnClickListener {
        //            Logger.d("click")
        //        }
        view1.post {
            view1Height = view1.height
        }
        view = findViewById(R.id.view2)
    }
}