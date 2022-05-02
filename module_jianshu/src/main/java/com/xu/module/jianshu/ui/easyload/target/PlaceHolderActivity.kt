package com.xu.module.jianshu.ui.easyload.target

import android.app.Activity
import android.os.Bundle
import com.xu.easyload.EasyLoad
import com.xu.module.jianshu.R
import com.xu.module.jianshu.ui.easyload.DelayUtil
import com.xu.module.jianshu.ui.easyload.state.ErrorState
import com.xu.module.jianshu.ui.easyload.state.PlaceHolderState

class PlaceHolderActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.j_activity_easy_load_normal)


        val service = EasyLoad.initLocal()
            .addLocalState(PlaceHolderState())
            .inject(this)

        //2s后加载失败布局
        DelayUtil.delay(service, ErrorState::class.java)


    }
}