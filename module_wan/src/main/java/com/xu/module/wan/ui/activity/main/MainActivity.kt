package com.xu.module.wan.ui.activity.main

import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.jaeger.library.StatusBarUtil
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.base.BaseActivity
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WActivityMainBinding
import com.xu.module.wan.viewmodel.HotKeyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.w_activity_main.*

@Route(path = ARouterPath.main)
@AndroidEntryPoint
class MainActivity(
    override val layoutId: Int = R.layout.w_activity_main,
    override val variableId: Int = BR.vm
) : BaseActivity<MainViewModel, WActivityMainBinding>() {

    private val hotKeyViewModel: HotKeyViewModel by viewModels()

    override fun initView(mDataBinding: WActivityMainBinding) {
        vp_main.isUserInputEnabled = false
        vp_main.adapter = object : FragmentStateAdapter(this) {

            override fun getItemCount() = 5

            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> ARouter.getInstance().build(ARouterPath.home).navigation() as Fragment
                    1 -> ARouter.getInstance().build(ARouterPath.project).navigation() as Fragment
                    2 -> ARouter.getInstance().build(ARouterPath.square).navigation() as Fragment
                    3 -> ARouter.getInstance().build(ARouterPath.wePublic).navigation() as Fragment
                    4 -> ARouter.getInstance().build(ARouterPath.mine).navigation() as Fragment
                    else -> ARouter.getInstance().build(ARouterPath.home).navigation() as Fragment
                }
            }
        }
        navigation.setOnNavigationItemSelectedListener {
            vp_main.setCurrentItem(it.order, false)
            when (it.order) {
                0, 1, 2, 3 -> StatusBarUtil.setDarkMode(this)
                4 -> StatusBarUtil.setLightMode(this)
            }
            true
        }
    }

    override fun initData() {
        hotKeyViewModel.getHotKey()
    }
}