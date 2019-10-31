package com.xu.module.video.ui.fragment.completed

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.base.BaseMvpFragment
import com.xu.commonlib.constant.ARouterPath
import com.xu.module.video.R

/**
 * @author 言吾許
 * 已经完成fragment
 */
@Route(path = ARouterPath.videoCompleted)
class CompletedFragment :
    BaseMvpFragment<ICompletedContract.ICompletedView, ICompletedContract.ICompletedPresenter>(),
    ICompletedContract.ICompletedView {
    override fun setLayoutId(): Int {
        return R.layout.v_fragment_completed
    }

    override fun initView(view: View) {
    }
}