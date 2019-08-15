package com.xu.module.jianshu.ui.retrofit

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.base.BaseActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.module.jianshu.R
import kotlinx.android.synthetic.main.j_activity_retrofit.*
import okhttp3.Callback
import okhttp3.OkHttpClient


/**
 * @author 言吾許
 */
@Route(path = ARouterPath.jianshuRetrofit)
class RetrofitTestActivity : BaseActivity() {
    override fun setLayoutId(): Int {
        return R.layout.j_activity_retrofit
    }

    override fun initView(savedInstanceState: Bundle?) {
        val movieApi = Retrofit
            .Builder()
            .baseUrl("http://123.321.1.11:7000")
            .client(OkHttpClient())
            .build()
            .create(MovieApi::class.java)


        bt_net.singleClick {

            //真正的请求要放在子线程中，没有结合rxJava
            val movieList = movieApi.getMovieList("2019")
            val movieDetail = movieApi.getMovieDetail("123")
            val listRes = movieList.execute()
            val detailRes = movieDetail.execute()
            if (listRes.isSuccessful) {

            }
            if (detailRes.isSuccessful) {

            }
            movieApi
                .getMovieList("2019")
                .execute()
        }
    }
}

