package com.xu.module.jianshu.ui.viewstub

import android.os.Bundle
import com.xu.commonlib.base.BaseActivity
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.module.jianshu.R
import kotlinx.android.synthetic.main.j_activity_view_stub.*

class ViewStubActivity : BaseActivity() {
    override fun setLayoutId(): Int {
        return R.layout.j_activity_view_stub
    }

    override fun initView(savedInstanceState: Bundle?) {
        bt_home.singleClick {
            vs_home.inflate()

        }

    }

    override fun initData() {

    }
}