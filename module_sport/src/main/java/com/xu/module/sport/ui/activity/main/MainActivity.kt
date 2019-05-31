package com.xu.module.sport.ui.activity.main

import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.gson.Gson
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.BaseApplication
import com.xu.commonlib.base.BaseMvpActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.module.sport.R
import javax.inject.Inject

/**
 * @author 言吾許
 */
@Route(path = ARouterPath.sportMain)
class MainActivity : BaseMvpActivity<IMainContract.IMainView, IMainContract.IMainPresenter>(), IMainContract.IMainView {

    @Inject
    lateinit var app: BaseApplication

    @Inject
    lateinit var gson: Gson


    override fun setLayoutId(): Int {
        return R.layout.s_activity_main
    }

    override fun initView() {
        mPresenter.sayHello()

        Toast.makeText(app, "hello 这是一个注解", Toast.LENGTH_SHORT).show()
    }

}