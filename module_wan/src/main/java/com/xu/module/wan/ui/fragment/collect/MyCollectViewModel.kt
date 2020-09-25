package com.xu.module.wan.ui.fragment.collect

import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.module.wan.ui.activity.login.CombineLiveData
import com.xu.module.wan.viewmodel.WanLiveData

class MyCollectViewModel @ViewModelInject constructor(
    appLiveData: WanLiveData
) : BaseViewModel() {


    val typeLiveData = MutableLiveData(-1)

    val loginState = appLiveData.loginStateLiveData

    /**
     * 是否展示登录按钮
     */
    var showLoginLiveData: MediatorLiveData<Int> =
        CombineLiveData(typeLiveData, loginState) { type, login ->
            if (type == 0 || type == 1) {
                if (login) {
                    View.GONE
                } else {
                    View.VISIBLE
                }
            } else {
                View.GONE
            }
        }


}