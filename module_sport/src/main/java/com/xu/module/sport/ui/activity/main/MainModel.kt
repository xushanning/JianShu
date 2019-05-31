package com.xu.module.sport.ui.activity.main

import com.orhanobut.logger.Logger
import com.xu.commonlib.mvp.BaseModel
import javax.inject.Inject

/**
 * @author 言吾許
 */
class MainModel @Inject constructor() : BaseModel(), IMainContract.IMainModel {
    override fun sayWoCao() {
        Logger.d("卧槽")
    }
}