package com.xu.module.wan.ui.activity.login

import android.app.Activity
import android.content.Intent
import com.alibaba.android.arouter.facade.annotation.Route
import com.jaeger.library.StatusBarUtil
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.mvvm.BaseVmActivity
import com.xu.commonlib.utlis.extention.observe
import com.xu.commonlib.utlis.extention.showToast
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@Route(path = ARouterPath.login)
@AndroidEntryPoint
class LoginActivity(
    override val layoutId: Int = R.layout.w_activity_login,
    override val variableId: Int = BR.viewModel
) : BaseVmActivity<LoginViewModel, WActivityLoginBinding>() {


    override fun initView(mDataBinding: WActivityLoginBinding) {
        mDataBinding.click = OnClick()
        StatusBarUtil.setLightMode(this)
    }

    override fun initData() {
        observe(mViewModel.loginResult) {
            if (it) {
                setResult(Activity.RESULT_OK)
                finish()
            }
        }
    }

    inner class OnClick {
        fun login() {
            when {
                mViewModel.userName.value.isEmpty() -> showToast(R.string.w_empty_username)
                mViewModel.password.value.isEmpty() -> showToast(R.string.w_empty_password)
                else -> mViewModel.doLogin()
            }
        }

        fun back() {
            finish()
        }
    }
}