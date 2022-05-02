package com.xu.module.jianshu.ui.reference

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.xu.commonlib.base.BaseActivity
import com.xu.module.jianshu.R
import kotlinx.android.synthetic.main.j_activity_view_stub.*
import java.lang.ref.SoftReference
import java.lang.ref.WeakReference
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

class ReferenceActivity : BaseActivity() {
    private var page = 0;
//    private val handler: Handler = object : Handler() {
//        override fun handleMessage(msg: Message?) {
//            super.handleMessage(msg)
//
//        }
//    }

    private val handler = MyHandler(this)
    override fun setLayoutId(): Int {
        return R.layout.j_activity_view_stub
    }

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun initData() {
        Executors.newSingleThreadExecutor().execute {
            val msg = Message.obtain()
            msg.what = 1
            handler.sendMessage(msg)
        }
    }

    private class MyHandler(activity: ReferenceActivity) : Handler() {
        //弱引用
        private var weakReference = WeakReference(activity)


        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (msg.what == 1) {
                weakReference.get()?.bt_home?.text = "hello world"
            }
        }
    }
}