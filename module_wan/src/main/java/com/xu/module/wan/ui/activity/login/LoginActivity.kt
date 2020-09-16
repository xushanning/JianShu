package com.xu.module.wan.ui.activity.login

import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.utlis.extention.observe
import com.xu.commonlib.utlis.extention.showToast
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.base.BaseActivity
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@Route(path = ARouterPath.login)
@AndroidEntryPoint
class LoginActivity(
    override val layoutId: Int = R.layout.w_activity_login,
    override val variableId: Int = BR.viewModel
) : BaseActivity<LoginViewModel, WActivityLoginBinding>() {


    override fun initView(mDataBinding: WActivityLoginBinding) {
        mDataBinding.click = OnClick()
    }

    override fun initData() {
        observe(mViewModel.loginResult) {
            if (it) {
                finish()
            }
        }
        mViewModel.showDialog.postValue("正在登陆")
    }

    override fun useLightMode(): Boolean {
        return true
    }

    inner class OnClick {
        fun login() {
            mViewModel.doLogin()
        }

        fun back() {
            finish()
        }

        fun forgetPassword() {
            showToast("密码忘了？重新申请个账号吧~")
        }
    }
}