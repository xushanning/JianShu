package com.xu.module.jianshu.ui.viewdrag

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.BaseActivity
import com.xu.module.jianshu.R
import kotlinx.android.synthetic.main.j_activity_view_drag.*

/**
 * @author 许 on 2021/12/11.
 */
class ViewDragActivity : BaseActivity() {
    override fun setLayoutId(): Int {
        return R.layout.j_activity_view_drag
    }

    override fun initView(savedInstanceState: Bundle?) {
        button.setOnClickListener {
            view1.visibility = View.GONE
        }
        lll.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    Logger.d("1111的ACTION_DOWN事件")
                }
                MotionEvent.ACTION_MOVE -> {
                    Logger.d("1111的ACTION_MOVE事件")
                }
                MotionEvent.ACTION_UP -> {
                    Logger.d("1111的ACTION_UP事件")
                }
            }

            return@setOnTouchListener false
        }
    }

    override fun initData() {
    }
}