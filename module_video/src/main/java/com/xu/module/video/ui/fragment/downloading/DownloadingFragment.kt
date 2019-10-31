package com.xu.module.video.ui.fragment.downloading

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.base.BaseMvpFragment
import com.xu.commonlib.constant.ARouterPath
import com.xu.module.video.R

/**
 * @author 言吾許
 * 正在下载fragment
 */
@Route(path = ARouterPath.videoDownloading)
class DownloadingFragment :
    BaseMvpFragment<IDownloadingContract.IDownloadingView, IDownloadingContract.IDownloadingPresenter>(),
    IDownloadingContract.IDownloadingView {
    override fun setLayoutId(): Int {
        return R.layout.v_fragment_downloading
    }

    override fun initView(view: View) {
    }
}