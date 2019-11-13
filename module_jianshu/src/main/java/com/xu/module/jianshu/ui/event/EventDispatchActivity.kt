package com.xu.module.jianshu.ui.event

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.base.BaseActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.commonlib.utlis.extention.singleClick
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
        bt_1.singleClick {

        }
    }

    override fun initData() {

    }
}