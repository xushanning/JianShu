package com.xu.commonlib.base.mvvm

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.launcher.ARouter
import com.xu.commonlib.utlis.extention.getVmClazz
import dagger.android.AndroidInjection

abstract class BaseVmActivity<VM : BaseViewModel, DB : ViewDataBinding> : AppCompatActivity() {
    lateinit var mDataBinding: DB
    lateinit var mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
        initDataBind()
        initViewModel()
        initView()
    }

    private fun initDataBind() {
        mDataBinding = DataBindingUtil.setContentView(this, layoutId())
        mDataBinding.lifecycleOwner = this
    }

    private fun initViewModel() {
        mViewModel = ViewModelProvider(this).get(getVmClazz(this))
    }

    abstract fun layoutId(): Int

    abstract fun initView()
}