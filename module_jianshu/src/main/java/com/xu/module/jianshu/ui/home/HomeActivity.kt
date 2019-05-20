package com.xu.module.jianshu.ui.home

import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.base.BaseActivity
import com.xu.commonlib.constant.ARouterContant
import com.xu.module.jianshu.R
import kotlinx.android.synthetic.main.j_activity_home.*

/**
 * @author 言吾許
 */
@Route(path = ARouterContant.jianShuHome)
class HomeActivity : BaseActivity() {
    override fun setLayoutId(): Int {
        return R.layout.j_activity_home
    }

    override fun initView() {
        bt_repeat_click.setOnClickListener {

        }
    }
}