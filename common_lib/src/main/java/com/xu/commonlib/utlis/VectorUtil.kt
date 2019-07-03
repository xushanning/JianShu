package com.xu.commonlib.utlis

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat

/**
 * @author 言吾許
 * vector格式图片工具类
 */
object VectorUtil {

    /**
     * 将vector类型图片转换为bitmap
     */
    fun vectorToBitmap(context: Context, resId: Int): Bitmap {
        var drawable: Drawable? = ContextCompat.getDrawable(context, resId)
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawable = (DrawableCompat.wrap(drawable!!)).mutate()
        }
        val bitmap = Bitmap.createBitmap(
            drawable!!.intrinsicWidth,
            drawable.intrinsicHeight, Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height);
        drawable.draw(canvas)
        return bitmap
    }
}