package com.xu.module.jianshu.ui.coroutine

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.base.BaseMvpActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.module.jianshu.R
import com.xu.module.jianshu.ui.proxy.ProxyTest
import kotlinx.android.synthetic.main.j_activity_coroutine.*

@Route(path = ARouterPath.jianshuCoroutine)
class CoroutineActivity :
    BaseMvpActivity<ICoroutineContract.ICoroutineView, ICoroutineContract.ICoroutinePresenter>(),
    ICoroutineContract.ICoroutineView {
    override fun setLayoutId(): Int {
        return R.layout.j_activity_coroutine
    }

    override fun initView(savedInstanceState: Bundle?) {
        bt_coroutine_start.singleClick {
            ProxyTest().testProxy()
        }
    }

    override fun initData() {

    }
}