package com.xu.module.read.ui.activity.splash

import com.alibaba.android.arouter.facade.annotation.Route


import com.xu.commonlib.utlis.extention.navigate
import com.xu.module.read.R
import com.xu.module.read.base.BaseActivity
import com.xu.module.read.constant.ARouterPath
import com.xu.module.read.databinding.RActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * 闪屏页
 */
@Route(path = ARouterPath.splash)
@AndroidEntryPoint
class SplashActivity(override val layoutId: Int = R.layout.r_activity_splash, override val variableId: Int = -1) :
    BaseActivity<SplashViewModel, RActivitySplashBinding>() {
    override fun initView(mDataBinding: RActivitySplashBinding) {
        navigate(ARouterPath.main)
    }

    override fun initData() {

    }
}