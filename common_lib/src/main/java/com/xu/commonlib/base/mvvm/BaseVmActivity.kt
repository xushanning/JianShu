package com.xu.commonlib.base.mvvm

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.launcher.ARouter
import com.xu.commonlib.utlis.extention.getVmClazz

abstract class BaseVmActivity<VM : BaseViewModel, DB : ViewDataBinding> : AppCompatActivity() {
    protected lateinit var mDataBinding: DB
    protected val mViewModel: VM by lazy { ViewModelProvider(this).get(getVmClazz(this)) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
        initDataBind()
        initView()
        initData()
    }

    private fun initDataBind() {
        mDataBinding = DataBindingUtil.setContentView(this, layoutId())
        mDataBinding.lifecycleOwner = this
        mDataBinding.setVariable(getVariableId(), mViewModel)
    }


    @LayoutRes
    abstract fun layoutId(): Int

    abstract fun getVariableId(): Int

    abstract fun initView()

    abstract fun initData()

}