package com.xu.module.jianshu.ui.easyload.target

import android.app.Activity
import android.os.Bundle
import com.xu.module.easyload.EasyLoad
import com.xu.module.jianshu.R
import com.xu.module.jianshu.ui.easyload.DelayUtil
import com.xu.module.jianshu.ui.easyload.state.ErrorState

class NormalActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.j_activity_easy_load_normal)
        val service = EasyLoad.instance
            .inject(this)

        //2s后加载成功布局
        DelayUtil.delay(service, ErrorState::class.java)
    }
}