package com.xu.module.jianshu.ui.home

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.BaseActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.module.jianshu.R
import com.xu.module.jianshu.ui.kotlin.InFix
import kotlinx.android.synthetic.main.j_activity_home.*

/**
 * @author 言吾許
 * 简书demo首页
 */
@Route(path = ARouterPath.jianShuHome)
class HomeActivity : BaseActivity() {


    override fun setLayoutId(): Int {
        return R.layout.j_activity_home
    }

    override fun initView(savedInstanceState: Bundle?) {
        //防重点
        bt_repeat_click.singleClick {
            ARouter.getInstance()
                .build(ARouterPath.jianshuRepeatClick)
                .navigation()
        }
        //scrollview嵌套RecyclerView嵌套数据ANR
        bt_anr.singleClick {
            showToast("没想到吧。。啥都没有")
            showToast("其实是懒。。没写")
        }
        //仿retrofit
        bt_retrofit.singleClick {
            ARouter.getInstance()
                .build(ARouterPath.jianshuRetrofit)
                .navigation()
        }

        //hook
        bt_hook.singleClick {
            ARouter.getInstance()
                .build(ARouterPath.jianshuHook)
                .navigation()
        }

        //event dispatch
        bt_event_dispatch.singleClick {
            ARouter.getInstance()
                .build(ARouterPath.jianshuEvent)
                .navigation()
        }
        //lambda表达式演变
        bt_lambda.singleClick {

        }
    }

    override fun initData() {
        val infix = InFix(6)
        val result = infix sum 6
        Logger.d(result)
    }
}