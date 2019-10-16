package com.xu.module.sport.ui.activity.screen

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.base.BaseActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.module.sport.R
import android.view.WindowManager
import com.xu.commonlib.utlis.extention.singleClick
import kotlinx.android.synthetic.main.s_activity_screen.*


/**
 * @author 言吾許
 */
@Route(path = ARouterPath.sportScreen)
class ScreenActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD or WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED)
        super.onCreate(savedInstanceState)
    }

    override fun setLayoutId(): Int {
        return R.layout.s_activity_screen
    }

    override fun initView(savedInstanceState: Bundle?) {
        //关闭
        img_close.singleClick {

        }
        //打开app
        tv_open_app.singleClick {

        }

    }
}