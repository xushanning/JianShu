package com.xu.module.wan.ui.login

import androidx.activity.viewModels
import com.xu.commonlib.base.mvvm.BaseVmActivity
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.databinding.WActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseVmActivity<LoginViewModel, WActivityLoginBinding>() {

    //val viewModel: LoginViewModel by viewModels()
    override fun layoutId() = R.layout.w_activity_login

    override fun getVariableId() = BR.viewModel

    override fun initView() {

    }

    override fun initData() {
        mViewModel.getListData()
    }
}