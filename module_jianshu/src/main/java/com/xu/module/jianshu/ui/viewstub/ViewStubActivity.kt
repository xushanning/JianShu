package com.xu.module.jianshu.ui.viewstub

import android.os.Bundle
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.BaseActivity
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.module.jianshu.R
import com.xu.module.jianshu.ui.rx.RxPlugins
import kotlinx.android.synthetic.main.j_activity_view_stub.*
import kotlin.concurrent.thread

class ViewStubActivity : BaseActivity() {
    override fun setLayoutId(): Int {
        return R.layout.j_activity_view_stub
    }

    override fun initView(savedInstanceState: Bundle?) {
        bt_home.singleClick {
            Thread {
                sayHello()
            }.start()

        }
        thread {

        }

    }

    override fun initData() {
        //RxPlugins().insert()
        sayHello()
    }

    @Synchronized
    private fun sayHello() {
        Logger.d(Thread.currentThread().name)
    }
}