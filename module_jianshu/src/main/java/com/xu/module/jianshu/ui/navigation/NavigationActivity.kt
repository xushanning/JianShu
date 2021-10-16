package com.xu.module.jianshu.ui.navigation

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.xu.commonlib.base.BaseActivity
import com.xu.module.jianshu.R

/**
 * @author 许 on 2021/9/21.
 */
class NavigationActivity : BaseActivity() {


    override fun setLayoutId(): Int {
        return R.layout.j_activity_navigation
    }

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun initData() {
    }

    override fun onSupportNavigateUp() =
        findNavController(R.id.my_nav_host_fragment).navigateUp()
}