package com.xu.module.jianshu.ui.eventdispatch

import android.os.Bundle
import android.view.MotionEvent
import com.alibaba.android.arouter.facade.annotation.Route
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.BaseActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.module.jianshu.R
import kotlinx.android.synthetic.main.j_activity_event_dispatch.*

/**
 * @author xu
 * 事件分发
 */
@Route(path = ARouterPath.jianshuEvent)
class EventDispatchActivity : BaseActivity() {
    override fun setLayoutId(): Int {
        return R.layout.j_activity_event_dispatch
    }

    override fun initView(savedInstanceState: Bundle?) {
//        v_child.setOnTouchListener { _, event ->
//            if (event.action == MotionEvent.ACTION_DOWN) {
//                Logger.d("子view的OnTouchListener")
//            }
//            //如果注册了OnTouchListener，并且返回了true，表示想自己处理touch事件，那么就不会走view的onTouchEvent
//            //了，如果返回false，那么两个都走，先走监听，在走onTouchEvent方法
//            false
//        }
//        v_child.setOnClickListener {
//            Logger.d("子view的OnClickListener")
//        }
//
//        v_grandfather.setOnTouchListener { _, event ->
//            if (event.action == MotionEvent.ACTION_DOWN) {
//                Logger.d("根viewgroup的OnTouchListener")
//            }
//            true
//        }
//
//        v_grandfather.setOnClickListener {
//            Logger.d("父view的OnClickListener")
//        }

        v_father.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                Logger.d("父viewgroup的OnTouchListener")
            }
            false
        }
        v_father.setOnClickListener {
            Logger.d("viewgroup点击")
        }

        v_child.setOnClickListener {
            Logger.d("子view点击")
        }

//        v_father.setOnClickListener {
//            Logger.d("父view的OnClickListener")
//        }

    }

    override fun initData() {

    }

//    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
//        if (ev?.action == MotionEvent.ACTION_DOWN) {
//            Logger.d("activity dispatchTouchEvent")
//        }
//        return super.dispatchTouchEvent(ev)
//    }
//
//    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        if (event?.action == MotionEvent.ACTION_DOWN) {
//            Logger.d("activity onTouchEvent")
//        }
//        return super.onTouchEvent(event)
//    }
}