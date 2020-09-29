package com.xu.commonlib.db

import com.xu.commonlib.utlis.Preference

object AppSp {

    /**
     * 夜间模式
     */
    var nightMode by Preference("nightMode", false)

    /**
     * 夜间模式透明度
     * 默认完全透明
     */
    var nightAlpha by Preference("nightAlpha", 0.5f)

}