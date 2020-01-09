package com.xu.module.jianshu.ui.easyload

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.orhanobut.logger.Logger
import com.xu.module.easyload.EasyLoad
import com.xu.module.easyload.service.ILoadService
import com.xu.module.easyload.listener.OnStateChangeListener
import com.xu.module.easyload.listener.OnReloadListener
import com.xu.module.easyload.state.BaseState
import com.xu.module.easyload.state.SuccessState
import com.xu.module.jianshu.R

class LoadingActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.j_activity_test_loading)
        //初始化全局
        EasyLoad.instance
                .addGlobalState(LoadingState())
                .addGlobalState(ErrorState())


        val service = EasyLoad.instance
                .addLocalState(PlaceHolderState())
                .setGlobalDefaultState(PlaceHolderState::class.java)
                .inject(this)
                .setOnReloadListener(object : OnReloadListener {
                    override fun onReload(iLoadService: ILoadService, clickState: BaseState, view: View) {
                        when (clickState) {
                            is LoadingState -> {
                                Logger.d("加载中state")
                                val tvLoading = view.findViewById<TextView>(R.id.tv_loading)
                                tvLoading.text = "修改了加载中的文案"
                            }
                            is ErrorState -> {
                                Logger.d("错误布局")
                            }
                        }

                        //点击重试加载loading布局
                        iLoadService.showState(LoadingState::class.java)
                        //两秒后加载成功布局
                        //DelayUtil.successDelay(iLoadService)
                        DelayUtil.delay(iLoadService, ErrorState::class.java)
                    }
                })
                .setOnStateChangeListener(object : OnStateChangeListener {
                    override fun onStateChange(view: View, currentState: BaseState) {
                        when (currentState) {
                            is PlaceHolderState -> {
                                Logger.d("当前是默认布局状态")
                            }
                            is LoadingState -> {
                                Logger.d("当前是加载中状态")
                            }
                            is ErrorState -> {
                                Logger.d("当前是错误状态")
                            }
                            is SuccessState -> {
                                Logger.d("当前是成功状态")
                            }
                        }
                    }

                })
        //2s后加载失败布局
        DelayUtil.delay(service, ErrorState::class.java)


    }
}