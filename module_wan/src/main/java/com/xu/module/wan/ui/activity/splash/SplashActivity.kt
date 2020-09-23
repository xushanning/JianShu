package com.xu.module.wan.ui.activity.splash

import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.utlis.extention.go
import com.xu.module.wan.R
import com.xu.module.wan.base.BaseActivity
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * 闪屏页
 */
@Route(path = ARouterPath.splash)
@AndroidEntryPoint
class SplashActivity(override val layoutId: Int = R.layout.w_activity_splash, override val variableId: Int = -1) :
    BaseActivity<SplashViewModel, WActivitySplashBinding>() {
    override fun initView(mDataBinding: WActivitySplashBinding) {
        go(ARouterPath.main)
    }

    override fun initData() {

    }
}