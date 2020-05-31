package com.xu.module.jianshu.ui.viewstub

import android.os.Bundle
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.BaseActivity
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.module.jianshu.R
import com.xu.module.jianshu.ui.handler.Handler
import com.xu.module.jianshu.ui.handler.Looper
import com.xu.module.jianshu.ui.handler.Message
import kotlinx.android.synthetic.main.j_activity_view_stub.*
import kotlin.concurrent.thread

class ViewStubActivity : BaseActivity() {

    //    private val handler = object : Handler() {
//        override fun handleMessage(msg: String) {
//            Logger.d(msg)
//            Logger.d(Thread.currentThread().name)
//        }
//    }
    private val handler: Handler = object : Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            Logger.d(msg?.obj)
            Logger.d(Thread.currentThread().name)
        }
    }


    override fun setLayoutId(): Int {
        return R.layout.j_activity_view_stub
    }

    override fun initView(savedInstanceState: Bundle?) {
        bt_home.singleClick {
            thread {
                Logger.d(Thread.currentThread().name)
                val msg = Message()
                msg.obj = "hello"
                handler.sendMessage(msg)
            }
        }
        Looper.prepare()


        Looper.loop()
    }

    override fun initData() {
        //RxPlugins().insert()
        //sayHello()
    }

    @Synchronized
    private fun sayHello() {
        Logger.d(Thread.currentThread().name)
    }
}