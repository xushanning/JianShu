package com.xu.module.jianshu.ui.home

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.xu.commonlib.base.BaseActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.module.jianshu.R
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
    }
}