package com.xu.module.jianshu.ui.coordinatorlayout.sample3

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.xu.commonlib.base.BaseActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.module.jianshu.R
import kotlinx.android.synthetic.main.j_activity_coordinator_sample3.*

@Route(path = ARouterPath.jianshuCoordinatorSample3)
class Sample3Activity : BaseActivity() {
    override fun setLayoutId(): Int {
        return R.layout.j_activity_coordinator_sample3
    }

    override fun initView(savedInstanceState: Bundle?) {
        val titles = ArrayList<String>().apply {
            add("tab1")
            add("tab2")
            add("tab3")
        }
        val fragmentList = ArrayList<Fragment>().apply {
            val fragment1 = ARouter.getInstance().build(ARouterPath.jianshuCoordinatorSample3Fragment).navigation() as Fragment
            val fragment2 = ARouter.getInstance().build(ARouterPath.jianshuCoordinatorSample3Fragment).navigation() as Fragment
            val fragment3 = ARouter.getInstance().build(ARouterPath.jianshuCoordinatorSample3Fragment).navigation() as Fragment
            add(fragment1)
            add(fragment2)
            add(fragment3)
        }
        val pagerAdapter = CoordinatorPagerAdapter(supportFragmentManager, fragmentList, titles)
        tl_coordinator.setupWithViewPager(vp_coordinator)
        vp_coordinator.adapter = pagerAdapter
    }

    override fun initData() {

    }
}