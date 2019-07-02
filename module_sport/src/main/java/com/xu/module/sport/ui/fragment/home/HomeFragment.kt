package com.xu.module.sport.ui.fragment.home

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.BaseMvpFragment
import com.xu.commonlib.constant.ARouterPath
import com.xu.module.sport.R
import com.xu.module.sport.widget.SlideFinishView
import kotlinx.android.synthetic.main.s_fragment_home.*

/**
 * @author 言吾許
 */
@Route(path = ARouterPath.sportHome)
class HomeFragment : BaseMvpFragment<IHomeContract.IHomeView, IHomeContract.IHomePresenter>(), IHomeContract.IHomeView {
    override fun setLayoutId(): Int {
        return R.layout.s_fragment_home
    }

    override fun initView(view: View) {

    }
}