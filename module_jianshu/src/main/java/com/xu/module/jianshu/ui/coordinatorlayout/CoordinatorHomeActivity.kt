package com.xu.module.jianshu.ui.coordinatorlayout

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.xu.commonlib.base.BaseActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.module.jianshu.R
import kotlinx.android.synthetic.main.j_activity_coordinator_home.*

/**
 * https://github.com/SheHuan/BehaviorDemo
 */
@Route(path = ARouterPath.jianshuCoordinatorHome)
class CoordinatorHomeActivity : BaseActivity() {
    override fun setLayoutId(): Int {
        return R.layout.j_activity_coordinator_home
    }

    override fun initView(savedInstanceState: Bundle?) {
        bt_sample1.singleClick {

        }
        bt_sample2.singleClick {
            ARouter.getInstance()
                    .build(ARouterPath.jianshuCoordinatorSample2)
                    .navigation()
        }
        bt_sample3.singleClick {

        }
        bt_sample4.singleClick {

        }
    }

    override fun initData() {
    }
}