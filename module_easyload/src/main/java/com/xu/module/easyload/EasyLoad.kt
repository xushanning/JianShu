package com.xu.module.easyload

import com.xu.module.easyload.listener.OnReloadListener
import com.xu.module.easyload.service.ILoadService
import com.xu.module.easyload.service.LoadService
import com.xu.module.easyload.state.BaseState

/**
 * @author xu
 */
class EasyLoad private constructor() {

    /**
     * 全局的status
     */
    private var globalStates: MutableList<BaseState>? = null
    /**
     * 局部的status
     */
    private var localStates: MutableList<BaseState>? = null
    /**
     * 默认的全局status
     */
    private var globalDefaultState: Class<out BaseState>? = null
    /**
     * 默认的局部status
     */
    private var localDefaultState: Class<out BaseState>? = null


    companion object {
        val instance: EasyLoad by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            EasyLoad()
        }
    }

    /**
     * 添加全局的status
     */
    fun addGlobalState(state: BaseState): EasyLoad {
        if (globalStates == null) {
            globalStates = ArrayList()
        }
        globalStates?.add(state)
        return this
    }


    /**
     * 添加局部的status
     */
    fun addLocalState(status: BaseState): EasyLoad {
        if (localStates == null) {
            localStates = ArrayList()
        }
        localStates?.add(status)
        return this
    }

    /**
     * 设置默认的status
     * 后设置会把前面设置的覆盖掉
     */
    fun setGlobalDefaultState(defaultStatus: Class<out BaseState>): EasyLoad {
        this.globalDefaultState = defaultStatus
        return this
    }

    /**
     * 添加全局的默认的state
     */
    fun setLocalDefaultState(localDefault: Class<out BaseState>): EasyLoad {
        this.localDefaultState = localDefault
        return this
    }

    /**
     *注入
     * @param target 只能是activity fragment view
     */
    fun inject(target: Any, reloadListener: OnReloadListener? = null): ILoadService {
        val localStates = this.localStates?.toMutableList()
        this.localStates?.clear()
        return LoadService(target, globalStates, localStates, globalDefaultState, localDefaultState, reloadListener)
    }

    /**
     * http://lison.cc/842.html?i=1
     * builder模式
     */
    class Builder {
        /**
         * 全局的status
         */
        private var globalStates: MutableList<BaseState>? = null


        fun addGlobalState(state: BaseState) = apply {

        }

        fun addLocalState() = apply {

        }
    }
}