package com.xu.module.sport.ui.activity.main

import android.view.LayoutInflater
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.google.gson.Gson
import com.xu.commonlib.base.BaseApplication
import com.xu.commonlib.base.BaseMvpActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.module.sport.R
import kotlinx.android.synthetic.main.s_activity_main.*
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

    private val tabName = arrayOf("我的", "发现", "运动", "路书", "好货")


    override fun setLayoutId(): Int {
        return R.layout.s_activity_main
    }

    override fun initView() {
        initTabLayout()
    }

    /**
     * 初始化tab
     */
    private fun initTabLayout() {

        val fragmentList = ArrayList<Fragment>()
            .apply {
                val fragment1 = ARouter.getInstance().build(ARouterPath.sportSport).navigation() as Fragment
                val fragment2 = ARouter.getInstance().build(ARouterPath.sportSport).navigation() as Fragment
                val fragment3 = ARouter.getInstance().build(ARouterPath.sportSport).navigation() as Fragment
                val fragment4 = ARouter.getInstance().build(ARouterPath.sportSport).navigation() as Fragment
                val fragment5 = ARouter.getInstance().build(ARouterPath.sportSport).navigation() as Fragment
                add(fragment1)
                add(fragment2)
                add(fragment3)
                add(fragment4)
                add(fragment5)
            }
        val pagerAdapter = MainPagerAdapter(supportFragmentManager, fragmentList)
        tl_main.setupWithViewPager(vp_main)
        vp_main.adapter = pagerAdapter



        for (i in tabName.indices) {
            val tab = tl_main.getTabAt(i)
            val view = LayoutInflater.from(this).inflate(R.layout.s_view_main_tab, null)
            val tvName = view.findViewById<TextView>(R.id.tv_name)
            tvName.text = tabName[i]
            tab!!.customView = view
        }

    }

}