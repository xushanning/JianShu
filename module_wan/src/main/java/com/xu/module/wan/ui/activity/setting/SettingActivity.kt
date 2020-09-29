package com.xu.module.wan.ui.activity.setting

import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.utlis.extention.observe
import com.xu.commonlib.utlis.extention.showToast
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.base.BaseActivity
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WActivitySettingBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * 设置Activity
 */
@Route(path = ARouterPath.setting)
@AndroidEntryPoint
class SettingActivity(override val layoutId: Int = R.layout.w_activity_setting, override val variableId: Int = BR.vm) :
    BaseActivity<SettingViewModel, WActivitySettingBinding>() {


    override fun initView(mDataBinding: WActivitySettingBinding) {
        mDataBinding.click = OnClick()
    }

    override fun initData() {

        observe(mViewModel.logoutLiveData) {
            if (it) {
                showToast("退出登录成功~")
                finish()
            } else {
                showToast("退出登录失败！")
            }
        }
    }

    inner class OnClick {
        /**
         * 退出登录
         */
        fun onExit() {
            mViewModel.logout()
        }

        fun back() {
            finish()
        }
    }
}