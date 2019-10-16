package com.xu.module.sport.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.alibaba.android.arouter.launcher.ARouter
import com.orhanobut.logger.Logger
import com.xu.commonlib.constant.ARouterPath

/**
 * @author 言吾許
 * 锁屏广播监听
 */
class ScreenLockReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent) {
        //锁屏广播
        if (intent.action == Intent.ACTION_SCREEN_OFF) {
            Logger.d("锁屏广播，启动锁屏activity...")
            ARouter.getInstance()
                    .build(ARouterPath.sportScreen)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    .navigation()
        }
    }
}