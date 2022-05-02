package com.xu.module.read.ui.activity.splash


import com.alibaba.android.arouter.facade.annotation.Route
import com.orhanobut.logger.Logger
import com.xu.commonlib.utlis.AssetUtil
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.module.read.R
import com.xu.module.read.base.BaseActivity
import com.xu.module.read.constant.ARouterPath
import com.xu.module.read.constant.TestContent
import com.xu.module.read.databinding.RActivitySplashBinding
import com.xu.module.read.pagegesture.UpDownPageGestureAdapter
import com.xu.module.read.util.PaintUtil
import com.xu.module.read.util.TextHandlerUtil
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.r_activity_splash.*

/**
 * 闪屏页
 */
@Route(path = ARouterPath.splash)
@AndroidEntryPoint
class SplashActivity(override val layoutId: Int = R.layout.r_activity_splash, override val variableId: Int = -1) :
    BaseActivity<SplashViewModel, RActivitySplashBinding>() {
    override fun initView(mDataBinding: RActivitySplashBinding) {
        //navigate(ARouterPath.main)
    }

    override fun initData() {
        read_view.setPageGestureAdapter(UpDownPageGestureAdapter(this))
        bt_draw.singleClick {
            //            val list = TextHandlerUtil.handleContentToLine(TestContent.getContent(), read_view.width + 0f, PaintUtil.bodyPaint)
            //            read_view.drawLines(list)
            read_view.setReaderHandler()
        }
    }
}