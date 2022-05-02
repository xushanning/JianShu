package com.xu.module.jianshu.ui.easyload.target

import android.os.Bundle
import com.xu.commonlib.base.BaseActivity
import com.xu.easyload.EasyLoad
import com.xu.easyload.state.SuccessState
import com.xu.module.jianshu.R
import com.xu.module.jianshu.ui.easyload.DelayUtil

/**
 * 保留toolbar
 */
class ToolBarActivity : BaseActivity() {
    override fun setLayoutId(): Int {
        return R.layout.j_activity_easy_load_tool_bar
    }

    override fun setStatusBar() {

    }

    override fun initView(savedInstanceState: Bundle?) {
        val service = EasyLoad.initLocal()
            .inject(this)
        DelayUtil.delay(service, SuccessState::class.java)
    }

    override fun initData() {

    }
}