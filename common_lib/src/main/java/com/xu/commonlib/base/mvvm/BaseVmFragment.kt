package com.xu.commonlib.base.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.launcher.ARouter
import com.xu.commonlib.utlis.extention.getVmClazz

abstract class BaseVmFragment<VM : BaseViewModel, DB : ViewDataBinding> : Fragment() {
    private lateinit var mDataBinding: DB
    protected val mViewModel: VM by lazy { ViewModelProvider(this).get(getVmClazz(this)) }
    abstract val layoutId: Int
    abstract val variableId: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mDataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        mDataBinding.lifecycleOwner = this
        mDataBinding.setVariable(variableId, mViewModel)
        return mDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ARouter.getInstance().inject(this)
        initView(mDataBinding)
        initData()
    }


    abstract fun initView(mDataBinding: DB)

    abstract fun initData()
}