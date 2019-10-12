package com.xu.module.jianshu.ui.hook

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import com.orhanobut.logger.Logger
import java.lang.reflect.Proxy

/**
 * @author 言吾許
 */
object ViewClickHookHelper {


    @SuppressLint("DiscouragedPrivateApi", "PrivateApi")
    fun hook(context: Context, view: View) {
        val method = View::class.java.getDeclaredMethod("getListenerInfo")
        method.isAccessible = true
        //这里拿到的就是mListenerInfo对象，也就是点击事件的持有者
        val mListenerInfo = method.invoke(view)

        //要从这里面拿到当前的点击事件对象 kotlin$为特殊字符，需要在前面加上\
        val listenerInfoClz = Class.forName("android.view.View\$ListenerInfo")
        val mOnClickListener = listenerInfoClz.getDeclaredField("mOnClickListener")
        mOnClickListener.isAccessible = true
        val onClickListenerInstance = mOnClickListener.get(mListenerInfo) as View.OnClickListener


        //动态代理
        val proxyOnClickListener = Proxy.newProxyInstance(context.classLoader, arrayOf(View.OnClickListener::class.java)) { _, proxyMethod, args ->
            Logger.d("自己的逻辑")
            //卧槽，这里的*非常重要~！！！！！报错一下午，最后发现：https://www.jianshu.com/p/078b8c6206b1
            proxyMethod.invoke(onClickListenerInstance, *args)
        }

        //3. 用我们自己的点击事件代理类，设置到"持有者"中
        mOnClickListener.set(mListenerInfo, proxyOnClickListener)
    }

}