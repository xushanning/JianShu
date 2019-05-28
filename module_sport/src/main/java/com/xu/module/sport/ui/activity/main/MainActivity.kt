package com.xu.module.sport.ui.activity.main

import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.base.BaseApplication
import com.xu.commonlib.base.BaseMvpActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.commonlib.di.component.AppComponent
import com.xu.module.sport.R
import com.xu.module.sport.di.component.DaggerActivityComponent

/**
 * @author 言吾許
 */
@Route(path = ARouterPath.sportMain)
class MainActivity : BaseMvpActivity<IMainContract.IMainView, IMainContract.IMainPresenter>(),
    IMainContract.IMainView {

    override fun initInject(appComponent: AppComponent) {
        DaggerActivityComponent
            .builder()
            .appComponent(appComponent)
            .build()
            .inject(this)
    }

    override fun setLayoutId(): Int {
        return R.layout.s_activity_main
    }

    override fun initView() {
        mPresenter.sayHello()
    }

}