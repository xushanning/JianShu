package com.xu.module.sport.ui.activity.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.google.gson.Gson
import com.orhanobut.logger.Logger
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

    override fun initView(savedInstanceState: Bundle?) {
        initTabLayout()
    }


    /**
     * 初始化tab
     */
    private fun initTabLayout() {

        val fragmentList = ArrayList<Fragment>()
            .apply {
                val fragment1 = ARouter.getInstance().build(ARouterPath.sportHome).navigation() as Fragment
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

        val iconList = ArrayList<Int>()
            .apply {
                add(R.drawable.s_selector_home)
                add(R.drawable.s_selector_find)
                add(R.drawable.s_vector_sport)
                add(R.drawable.s_selector_home)
                add(R.drawable.s_selector_home)
            }
        val pagerAdapter = MainPagerAdapter(supportFragmentManager, fragmentList)
        tl_main.setupWithViewPager(vp_main)
        vp_main.adapter = pagerAdapter



        for (i in tabName.indices) {
            val tab = tl_main.getTabAt(i)
            val view = LayoutInflater.from(this).inflate(R.layout.s_view_main_tab, null)
            val tvName = view.findViewById<TextView>(R.id.tv_name)
            val imgTab = view.findViewById<ImageView>(R.id.img_tab)

            if (i == 2) {
                val tlItemBg = view.findViewById<View>(R.id.v_bg)
                tlItemBg.setBackgroundColor(ContextCompat.getColor(this, R.color.s_color_blue))
                tvName.setTextColor(ContextCompat.getColor(this, android.R.color.white))
                view.tag = i
                view.setOnClickListener {
                    if (view.tag as Int == 2) {
                        //转场动画
                        val compat = ActivityOptionsCompat.makeCustomAnimation(
                            this,
                            R.anim.s_slide_bottom_top,
                            R.anim.s_slide_un_move
                        )
                        ARouter.getInstance()
                            .build(ARouterPath.sportRealTimeTrajectory)
                            .withFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                            .withOptionsCompat(compat)
                            .navigation(this@MainActivity)
                    }
                }
            }

            if (i == 1 || i == 3 || i == 4) {
                val vTodo = view.findViewById<View>(R.id.v_todo)
                vTodo.visibility = View.VISIBLE
            }
            tvName.text = tabName[i]
            imgTab.setImageResource(iconList[i])
            tab!!.customView = view
        }

    }


}