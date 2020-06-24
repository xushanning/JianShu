package com.xu.module.easyload

import android.util.Log
import com.xu.module.easyload.listener.OnReloadListener
import com.xu.module.easyload.listener.OnStateChangeListener
import com.xu.module.easyload.service.ILoadService
import com.xu.module.easyload.service.LoadService
import com.xu.module.easyload.state.BaseState
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.Serializable

/**
 * @author xu
 */
class EasyLoad private constructor() {

    companion object {
        val instance: EasyLoad by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            EasyLoad()
        }
        private val builder: Builder by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            Builder()
        }
    }

    fun beginBuilder(): Builder {
        return builder
    }

    /**
     *注入
     * @param target 只能是activity fragment view
     */

    fun inject(target: Any): ILoadService {
        //清除builder的localState和defaultLocalState
        val cloneBuilder = builder.copy()
        builder.localDefaultState = null
        builder.onReloadListener = null
        builder.onStateChangeListener = null
        builder.localStates.clear()
        val service=LoadService(target, cloneBuilder)
        Log.d("tag",service.toString())
        return service
    }

    /**
     * http://lison.cc/842.html?i=1
     * builder模式
     */
    class Builder : Serializable {
        /**
         * 全局的status
         */
        val globalStates: MutableList<BaseState> = ArrayList()
        /**
         * 局部status
         */
        val localStates: MutableList<BaseState> = ArrayList()

        /**
         * 默认的全局status
         */
        var globalDefaultState: Class<out BaseState>? = null
        /**
         * 默认的局部status
         */
        var localDefaultState: Class<out BaseState>? = null
        /**
         * 重新加载监听
         */
        var onReloadListener: OnReloadListener? = null

        /**
         * 状态改变监听
         */
        var onStateChangeListener: OnStateChangeListener? = null

        /**
         * 添加全局的state
         */
        fun addGlobalState(state: BaseState) = apply {
            if (!globalStates.contains(state)) {
                globalStates.add(state)
            }
        }

        /**
         *添加局部的state
         */
        fun addLocalState(state: BaseState) = apply {
            if (!localStates.contains(state)) {
                localStates.add(state)
            }
        }

        /**
         * 设置默认的status
         * 后设置会把前面设置的覆盖掉
         */
        fun setGlobalDefaultState(defaultStatus: Class<out BaseState>) = apply {
            //todo 是不是可以通过判断如果不是null的话，就抛异常？做到只初始化一次？
            this.globalDefaultState = defaultStatus
        }

        /**
         * 添加全局的默认的state
         */
        fun setLocalDefaultState(localDefault: Class<out BaseState>) = apply {
            this.localDefaultState = localDefault
        }

        /**
         * 设置重新加载监听
         */
        fun setOnReloadListener(onReloadListener: OnReloadListener) = apply {
            this.onReloadListener = onReloadListener
        }

        /**
         * 设置重新加载监听
         */
        fun setOnStateChangeListener(onStateChangeListener: OnStateChangeListener) = apply {
            this.onStateChangeListener = onStateChangeListener
        }

        /**
         * 注入
         */
        fun inject(target: Any): ILoadService {
            return instance.inject(target)
        }

        /**
         * 复制对象
         */
        fun copy(): Builder {
            val bos = ByteArrayOutputStream()
            val oos = ObjectOutputStream(bos)
            oos.writeObject(this@Builder)
            val bis = ByteArrayInputStream(bos.toByteArray())
            val ois = ObjectInputStream(bis)
            return ois.readObject() as Builder
        }

    }
}