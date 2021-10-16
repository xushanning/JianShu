package com.xu.module.jianshu.ui.navigation

import android.view.View
import androidx.navigation.Navigation
import com.xu.commonlib.base.BaseFragment
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.module.jianshu.R
import kotlinx.android.synthetic.main.j_fragment_1.*

/**
 * @author 许 on 2021/9/21.
 */
class Fragment1 : BaseFragment() {
    override fun setLayoutId(): Int {
        return R.layout.j_fragment_1
    }

    override fun initView(view: View) {
        bt_navigate.singleClick {
            Navigation.findNavController(it).navigate(R.id.action1)
        }
    }

    override fun initData() {
        TODO("Not yet implemented")
    }
}