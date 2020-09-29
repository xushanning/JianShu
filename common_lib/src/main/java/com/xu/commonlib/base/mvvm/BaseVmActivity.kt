package com.xu.commonlib.base.mvvm

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.launcher.ARouter
import com.jaeger.library.StatusBarUtil
import com.orhanobut.logger.Logger
import com.xu.commonlib.R
import com.xu.commonlib.db.AppSp
import com.xu.commonlib.utlis.extention.getVmClazz
import com.xu.commonlib.utlis.extention.observe

abstract class BaseVmActivity<VM : BaseViewModel, DB : ViewDataBinding> : AppCompatActivity(),
    IBaseVmView {
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
        observeDialogChange()
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
     * 订阅dialog状态变化
     */
    private fun observeDialogChange() {
        observe(mViewModel.showDialog) {
            showLoading(it)
        }
        observe(mViewModel.dismissDialog) {
            dismissLoading()
        }
        observe(mViewModel.nightMode) {
            nightMode(it, mViewModel.nightAlpha.value)
        }
        observe(mViewModel.nightAlpha) {
            nightMode(mViewModel.nightMode.value, it)
        }
    }


    /**
     * 是否开启LightMode
     */
    open fun useLightMode(): Boolean {
        return false
    }


    private fun nightMode(night: Boolean, alpha: Int) {
        val fAlpha = alpha.toFloat() / 100
        AppSp.run {
            nightMode = night
            nightAlpha = fAlpha
        }
        if (night) {
            val handler = Handler(Looper.getMainLooper())
            handler.postAtFrontOfQueue {
                decorView?.apply {
                    val view = findViewById<View>(nightViewId)
                    if (view == null) {
                        val maskView = View(this@BaseVmActivity)
                        maskView.layoutParams = ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                        )
                        maskView.alpha = fAlpha
                        maskView.setBackgroundColor(getColor(R.color.black))
                        maskView.id = nightViewId
                        addView(maskView)
                    } else {
                        view.alpha = fAlpha
                    }
                }
            }
        } else {
            decorView?.apply {
                findViewById<View>(nightViewId)?.let { removeView(it) }
            }
        }
    }

    /**
     * 获取id
     */
    private fun getId(): Int {
        var id = java.lang.String("nightMode").bytes.sum()
        if (id == 48) id = 0
        return id
    }

    private val decorView: FrameLayout?
        get() = (takeIf { !isFinishing && !isDestroyed }?.window?.decorView) as? FrameLayout

    private val nightViewId: Int = getId()

}