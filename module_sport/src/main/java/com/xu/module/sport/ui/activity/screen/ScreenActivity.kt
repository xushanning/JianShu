package com.xu.module.sport.ui.activity.screen

import android.app.KeyguardManager
import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.base.BaseActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.module.sport.R
import com.xu.module.sport.beans.ScreenDataBean
import kotlinx.android.synthetic.main.s_activity_screen.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


/**
 * @author 言吾許
 */
@Route(path = ARouterPath.sportScreen)
class ScreenActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.addFlags(
                //解锁
                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                        //锁屏状态下显示
                        or WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                        //保持屏幕长亮
                        or WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                        //打开屏幕
                        or WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)
    }

    override fun setLayoutId(): Int {
        return R.layout.s_activity_screen
    }

    override fun initView(savedInstanceState: Bundle?) {
        tv_mileage.text = getString(R.string.s_home_sport_total_mileage, "0.00")
        tv_time.text = getString(R.string.s_real_time_init_time)
        tv_speed.text = getString(R.string.s_real_time_init_speed)
        //关闭
        img_close.singleClick {

        }
        //打开app
        tv_open_app.singleClick {
            val keyguardManager = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
            keyguardManager.newKeyguardLock("").disableKeyguard()
            //todo 如何恢复实时到实时轨迹界面，下面的代码，进去后，新建了一个activity
//            ARouter.getInstance()
//                    .build(ARouterPath.sportRealTimeTrajectory)
//                    .withFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
//                    .navigation(this@ScreenActivity)
            finish()
        }

    }

    /**
     * 加载来自service的运动数据
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun refreshSportData(data: ScreenDataBean) {
        tv_mileage.text = String.format("%.2f", data.mileage / 1000)
        tv_time.text = data.sportTime
        tv_speed.text = data.speed.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }
}