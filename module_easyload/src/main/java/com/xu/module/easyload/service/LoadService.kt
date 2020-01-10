package com.xu.module.easyload.service

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.xu.module.easyload.EasyLoad
import com.xu.module.easyload.listener.OnStateChangeListener
import com.xu.module.easyload.state.BaseState
import com.xu.module.easyload.state.SuccessState

class LoadService(target: Any, builder: EasyLoad.Builder) : ILoadService {
    private lateinit var container: ViewGroup
    private lateinit var originalView: View
    private lateinit var originalLayoutParams: ViewGroup.LayoutParams
    private lateinit var mContext: Context

    /**
     * 存放state
     */
    private val mStates = HashMap<Class<out BaseState>, BaseState>()
    /**
     * 除去成功的当前的view
     */
    private var currentOtherStateView: View? = null
    private var onStateChangedListener: OnStateChangeListener? = null


    init {
        initTarget(target)
        initStates(builder)
    }

    private fun initTarget(target: Any) {

        when (target) {
            is Activity -> {
                container = target.findViewById(android.R.id.content)
                //activity初始化状态就一个view
                originalView = container.getChildAt(0)
                mContext = target
                originalLayoutParams = originalView.layoutParams
            }
            //fragment和view都传入view
            is View -> {
                val parentViewGroup = target.parent as ViewGroup
                container = FrameLayout(target.context)
                originalView = target
                mContext = originalView.context
                originalLayoutParams = originalView.layoutParams
                container.layoutParams = originalLayoutParams
                parentViewGroup.removeView(target)
                parentViewGroup.addView(container)
            }
            else -> {
                throw IllegalArgumentException("target必须是activity、view的一种")
            }
        }

    }

    private fun initStates(builder: EasyLoad.Builder) {

        val globalStates = builder.globalStates
        val localStates = builder.localStates
        val reloadListener = builder.onReloadListener
        val localDefaultState = builder.localDefaultState
        val globalDefaultState = builder.globalDefaultState
        this.onStateChangedListener = builder.onStateChangeListener
        if (globalStates.isEmpty() && localStates.isEmpty()) {
            throw IllegalArgumentException("globalState和localState必须设置其一~！")
        }
        //全局state初始化
        globalStates.forEach {
            it.initView(mContext, reloadListener)
            mStates[it.javaClass] = it
        }
        //local会把全局覆盖
        localStates.forEach {
            it.initView(mContext, reloadListener)
            mStates[it.javaClass] = it
        }
        //成功state
        val successState = SuccessState(originalView, mContext, reloadListener)
        mStates[successState.javaClass] = successState
        //只要是localDefaultState不为空，那么local生效
        if (localDefaultState != null) {
            showDefault(localDefaultState)
        }
        //只有local为null，并且global不为null的情况下，global才生效
        if (globalDefaultState != null && localDefaultState == null) {
            showDefault(globalDefaultState)
        }
    }

    /**
     * 展示默认的state
     */
    private fun showDefault(defaultState: Class<out BaseState>) {
        if (!mStates.containsKey(defaultState)) {
            throw IllegalArgumentException("未实例化${defaultState.simpleName}")
        }
        //存在默认，那么展示默认
        showState(defaultState)
    }

    /**
     * 成功
     */
    override fun showSuccess() {
        showState(SuccessState::class.java)
    }

    /**
     * 展示state
     */
    override fun showState(clState: Class<out BaseState>) {
        if (!mStates.containsKey(clState)) {
            throw IllegalArgumentException("未实例化${clState.simpleName}")
        }

        //核心
        val state = mStates[clState]
        val view = state!!.getView(this, state)
        onStateChangedListener?.onStateChange(view, state)
        if (state is SuccessState) {
            //成功的话，就把原始界面跳转到最前面
            view.visibility = View.VISIBLE
            currentOtherStateView?.visibility = View.GONE
        } else {
            //相同，不变
            if (currentOtherStateView == view) {
                return
            }
            //先把当前的view
            container.removeView(currentOtherStateView)
            val stateValue = mStates[SuccessState::class.java]
            stateValue?.getView(this, stateValue)?.visibility = View.GONE
            view.layoutParams = originalLayoutParams
            container.addView(view)
            currentOtherStateView = view
        }

    }


}