package com.xu.module.wan.ui.login

import com.xu.commonlib.base.mvvm.BaseVmActivity
import com.xu.commonlib.utlis.extention.showToast
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.databinding.WActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseVmActivity<LoginViewModel, WActivityLoginBinding>() {


    //val viewModel: LoginViewModel by viewModels()
    override fun layoutId() = R.layout.w_activity_login

    override fun getVariableId() = BR.viewModel

    override fun initView(mDataBinding: WActivityLoginBinding) {
        mDataBinding.click = OnClick()


    }

    override fun initData() {
        mViewModel.userName.observe(this, {
            //Logger.d(it)
        })
    }

    inner class OnClick {
        fun login() {
            when {
                mViewModel.userName.value.isEmpty() -> showToast(R.string.w_empty_username)
                mViewModel.password.value.isEmpty() -> showToast(R.string.w_empty_password)
                else -> mViewModel.doLogin()
            }
        }
    }
}