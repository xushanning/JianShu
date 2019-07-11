package com.xu.module.sport.ui.fragment.sport

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.xu.commonlib.base.BaseMvpFragment
import com.xu.commonlib.constant.ARouterPath
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.module.sport.R
import kotlinx.android.synthetic.main.s_fragment_sport.*

/**
 * @author 言吾許
 * 运动主界面fragment
 */
@Route(path = ARouterPath.sportSport)
class SportFragment : BaseMvpFragment<ISportContract.ISportView, ISportContract.ISportPresenter>(),
    ISportContract.ISportView {
    override fun setLayoutId(): Int {
        return R.layout.s_fragment_sport
    }

    override fun initView(view: View) {

    }
}