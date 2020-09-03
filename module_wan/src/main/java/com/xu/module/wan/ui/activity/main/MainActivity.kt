package com.xu.module.wan.ui.activity.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.mvvm.BaseVmActivity
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import it.sephiroth.android.library.bottomnavigation.BottomNavigation
import kotlinx.android.synthetic.main.w_activity_main.*

@Route(path = ARouterPath.main)
@AndroidEntryPoint
class MainActivity(
    override val layoutId: Int = R.layout.w_activity_main,
    override val variableId: Int = BR.vm
) : BaseVmActivity<MainViewModel, WActivityMainBinding>() {

    override fun initView(mDataBinding: WActivityMainBinding) {
        vp_main.isUserInputEnabled = false
        vp_main.adapter = object : FragmentStateAdapter(this) {

            override fun getItemCount() = 3

            override fun getItem(position: Int): Fragment {
                return when (position) {
                    0 -> ARouter.getInstance().build(ARouterPath.home).navigation() as Fragment
                    1 -> ARouter.getInstance().build(ARouterPath.project).navigation() as Fragment
                    2 -> ARouter.getInstance().build(ARouterPath.square).navigation() as Fragment
                    else -> ARouter.getInstance().build(ARouterPath.home).navigation() as Fragment
                }
            }
        }

        navigation.menuItemSelectionListener =
            object : BottomNavigation.OnMenuItemSelectionListener {
                override fun onMenuItemReselect(itemId: Int, position: Int, fromUser: Boolean) {
                }

                override fun onMenuItemSelect(itemId: Int, position: Int, fromUser: Boolean) {
                    vp_main.setCurrentItem(position, false)
                }
            }
    }

    override fun initData() {

    }
}