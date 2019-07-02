package com.xu.commonlib.utlis

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.net.Uri
import com.orhanobut.logger.Logger


/**
 * @author 许 on 2019/7/2.
 */
object GpsUtil {
    /**
     *  GPS是否打开
     */
    fun isOpen(context: Context): Boolean {
        val manager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return manager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }

    /**
     * 打开gps
     */
    fun openGps(context: Context) {
        val intent = Intent()
        intent.setClassName(
            "com.android.settings",
            "com.android.settings.widget.SettingsAppWidgetProvider"
        )
        intent.addCategory("android.intent.category.ALTERNATIVE")
        intent.data = Uri.parse("custom:3")
        try {
            PendingIntent.getBroadcast(context, 0, intent, 0).send()
        } catch (e: PendingIntent.CanceledException) {
            e.printStackTrace()
            Logger.d(e.message)
        }

    }
}