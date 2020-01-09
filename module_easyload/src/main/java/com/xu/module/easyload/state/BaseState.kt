package com.xu.module.easyload.state

import android.content.Context
import android.util.Log
import android.view.View
import androidx.annotation.LayoutRes
import com.xu.module.easyload.service.ILoadService
import com.xu.module.easyload.listener.OnReloadListener

/**
 * base
 */
abstract class BaseState {
    private var view: View? = null
    private var context: Context? = null
    private var onReloadListener: OnReloadListener? = null


    companion object {
        /**
         *
         */
        const val NO_RES_LAYOUT = 0
    }

    constructor()

    constructor(view: View, context: Context, onReloadListener: OnReloadListener? = null) {
        this.view = view
        this.context = context
        this.onReloadListener = onReloadListener
    }

    fun initView(context: Context, onReloadListener: OnReloadListener? = null) {
        this.context = context
        this.onReloadListener = onReloadListener
    }

    /**
     * 初始化view
     */
    fun getView(loadService: ILoadService, currentState: BaseState): View {
        //原始view因为直接返回，所以没有监听
        if (view != null) {
            return view!!
        }
        val resId = onCreateView()
        if (resId != NO_RES_LAYOUT) {
            view = View.inflate(context, onCreateView(), null)
        }
        view?.setOnClickListener {
            if (canReloadable()) {
                Log.d("点击", (onReloadListener == null).toString())
                onReloadListener?.onReload(loadService, currentState, it)
            }
        }

        return view!!
    }


    /**
     * 设置布局
     */
    @LayoutRes
    protected abstract fun onCreateView(): Int

    /**
     * 是否能点击重新加载，默认不能false
     */
    open fun canReloadable(): Boolean {
        return false
    }

    /**
     * 设置重新加载监听
     */
    fun setOnReloadListener(onReloadListener: OnReloadListener) {
        this.onReloadListener = onReloadListener
    }

    /**
     * 绑定view
     */
    open fun attachView() {

    }

    /**
     * 解绑view
     */
    open fun detachView() {

    }


}