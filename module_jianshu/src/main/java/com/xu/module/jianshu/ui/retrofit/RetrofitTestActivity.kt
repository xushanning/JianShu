package com.xu.module.jianshu.ui.retrofit

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.bumptech.glide.Glide
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.BaseActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.module.jianshu.R
import kotlinx.android.synthetic.main.j_activity_retrofit.*
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Response
import java.io.IOException


/**
 * @author 言吾許
 */
@Route(path = ARouterPath.jianshuRetrofit)
class RetrofitTestActivity : BaseActivity() {

    override fun setLayoutId(): Int {
        return R.layout.j_activity_retrofit
    }

    override fun initView(savedInstanceState: Bundle?) {
        //初始化retrofit
        val api = Retrofit
            .Builder()
            .baseUrl("https://wanandroid.com")
            .client(OkHttpClient())
            .build()
            .create(ServiceApi::class.java)

        //按钮点击
        bt_net.singleClick {
            api.getPublicList()
                .enqueue(object : Callback {
                    override fun onFailure(call: Call, e: IOException) {
                        Logger.d(e.message)
                    }

                    override fun onResponse(call: Call, response: Response) {
                        val res = response.body?.source()?.readUtf8()
                        Logger.d(res)
                    }
                })
        }
    }

    override fun initData() {

    }
}

