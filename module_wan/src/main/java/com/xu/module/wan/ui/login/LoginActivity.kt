package com.xu.module.wan.ui.login

import com.xu.commonlib.base.mvvm.BaseVmActivity
import com.xu.module.wan.R
import com.xu.module.wan.api.WanService
import com.xu.module.wan.databinding.WActivityLoginBinding
import javax.inject.Inject

class LoginActivity : BaseVmActivity<LoginViewModel, WActivityLoginBinding>() {
    @Inject
    lateinit var api: WanService

    // private val view: LoginViewModel by viewModels()

    override fun layoutId() = R.layout.w_activity_login
    override fun initView() {
        mDataBinding.vm = mViewModel
        mViewModel.test()
    }

}