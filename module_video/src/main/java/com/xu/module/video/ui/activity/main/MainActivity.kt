package com.xu.module.video.ui.activity.main

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.BaseMvpActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.commonlib.utlis.TransformUtil
import com.xu.module.video.R
import com.xu.module.video.http.VideoApi
import kotlinx.android.synthetic.main.v_activity_main.*
import javax.inject.Inject

/**
 * @author 言吾許
 */
@Route(path = ARouterPath.videoMain)
class MainActivity : BaseMvpActivity<IMainContract.IMainView, IMainContract.IMainPresenter>(),
    IMainContract.IMainView {


    override fun setLayoutId(): Int {
        return R.layout.v_activity_main
    }

    override fun initView(savedInstanceState: Bundle?) {
        initTabLayout()
    }

    override fun initData() {
        mPresenter.getShareHtml("http://v.douyin.com/xU4jXA/ ")
    }

    private fun initTabLayout() {
        val fragmentList = ArrayList<Fragment>()
            .apply {
                //已完成
                val completedFragment =
                    ARouter.getInstance().build(ARouterPath.videoCompleted).navigation() as Fragment
                //正在下载
                val downloadingFragment =
                    ARouter.getInstance().build(ARouterPath.videoDownloading).navigation() as Fragment
                add(completedFragment)
                add(downloadingFragment)

            }

        val pagerAdapter = MainPagerAdapter(supportFragmentManager, fragmentList)
        tl_main.setupWithViewPager(vp_main)
        vp_main.adapter = pagerAdapter

    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showToast("退出吗？")
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}