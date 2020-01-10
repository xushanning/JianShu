package com.xu.module.jianshu.ui.easyload.target

import android.app.Activity
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.orhanobut.logger.Logger
import com.xu.module.easyload.EasyLoad
import com.xu.module.easyload.listener.OnStateChangeListener
import com.xu.module.easyload.state.BaseState
import com.xu.module.easyload.state.SuccessState
import com.xu.module.jianshu.R
import com.xu.module.jianshu.ui.easyload.state.GlobalDefaultState
import kotlinx.android.synthetic.main.j_activity_easy_load_view.*

class ViewActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.j_activity_easy_load_view)
        val service = EasyLoad.instance
                .beginBuilder()
                .setOnStateChangeListener(object : OnStateChangeListener {
                    override fun onStateChange(view: View, currentState: BaseState) {
                        when (currentState) {
                            is SuccessState -> {
                                Logger.d("成功")
                            }
                            is GlobalDefaultState -> {
                                Logger.d("全局默认")
                            }
                        }
                    }

                })
                .inject(img_view)

        Glide.with(this)
                .load("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=4177056998,326509749&fm=26&gp=0.jpg")
                .listener(object : RequestListener<Drawable> {

                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        Logger.d(e?.message)
                        return false
                    }

                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        Logger.d("chenggonglea a a ")
                        service.showSuccess()
                        return false
                    }

                })
                .into(img_view)

        Glide.with(this)
                .load("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=4177056998,326509749&fm=26&gp=0.jpg")
                .listener(object : RequestListener<Drawable> {

                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        Logger.d(e?.message)
                        return false
                    }

                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        return false
                    }

                })
                .into(img2)
    }
}