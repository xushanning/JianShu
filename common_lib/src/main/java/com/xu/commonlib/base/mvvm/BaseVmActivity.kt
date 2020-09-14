package com.xu.commonlib.base.mvvm

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.launcher.ARouter
import com.jaeger.library.StatusBarUtil
import com.xu.commonlib.utlis.extention.getVmClazz

abstract class BaseVmActivity<VM : BaseViewModel, DB : ViewDataBinding> : AppCompatActivity() {
    private lateinit var mDataBinding: DB
    protected val mViewModel: VM by lazy { ViewModelProvider(this).get(getVmClazz(this)) }
    abstract val layoutId: Int
    abstract val variableId: Int
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
        StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null)
        if (useLightMode()) {
            StatusBarUtil.setLightMode(this)
        }
        initDataBind()
        initView(mDataBinding)
        initData()
    }

    private fun initDataBind() {
        mDataBinding = DataBindingUtil.setContentView(this, layoutId)
        mDataBinding.lifecycleOwner = this
        mDataBinding.setVariable(variableId, mViewModel)
    }

    abstract fun initView(mDataBinding: DB)

    abstract fun initData()

    /**
     * 是否开启LightMode
     */
    open fun useLightMode(): Boolean {
        return false
    }

}