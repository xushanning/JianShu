package com.xu.module.sport.ui.activity.main

import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.base.BaseMvpActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.module.sport.R

/**
 * @author 言吾許
 */
@Route(path = ARouterPath.sportMain)
class MainActivity : BaseMvpActivity<IMainContract.IMainView, IMainContract.IMainPresenter>(),
    IMainContract.IMainView {
    override fun setPresenter(): IMainContract.IMainPresenter {
        return MainPresenter()
    }

    override fun setLayoutId(): Int {
        return R.layout.s_activity_main
    }


}