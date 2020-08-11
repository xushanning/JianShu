package com.xu.module.jianshu.ui.easyload.target

import android.app.Activity
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.TextView
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
        val serviceConstraint = EasyLoad.instance
                .beginBuilder()
                .setOnStateChangeListener(object : OnStateChangeListener {
                    override fun onStateChange(view: View, currentState: BaseState) {
                        when (currentState) {
                            is SuccessState -> {
                                Logger.d("成功")
                            }
                            is GlobalDefaultState -> {
                                val tvContent = view.findViewById<TextView>(R.id.tv_content)
                                tvContent.text = "constraint的默认"
                            }
                        }
                    }

                })
                .inject(img_constraint)

        Glide.with(this)
                .load("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=4177056998,326509749&fm=26&gp=0.jpg")
                .listener(object : RequestListener<Drawable> {

                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        Logger.d(e?.message)
                        return false
                    }

                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        Logger.d("constraintLayout加载成功")
                        serviceConstraint.showSuccess()
                        return false
                    }

                })
                .into(img_constraint)

//        val serviceRelative = EasyLoad.instance
//                .beginBuilder()
//                .setOnStateChangeListener(object : OnStateChangeListener {
//                    override fun onStateChange(view: View, currentState: BaseState) {
//                        when (currentState) {
//                            is SuccessState -> {
//                                //  Logger.d("成功")
//                            }
//                            is GlobalDefaultState -> {
//                                val tvContent = view.findViewById<TextView>(R.id.tv_content)
//                                tvContent.text = "Relative的默认"
//                            }
//                        }
//                    }
//
//                })
//                .inject(img_relative)
//
//        Glide.with(this)
//                .load("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3770062302,1485665606&fm=26&gp=0.jpg")
//                .listener(object : RequestListener<Drawable> {
//
//                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
//                        Logger.d(e?.message)
//                        return false
//                    }
//
//                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
//                        Logger.d("相对布局的加载成功")
//                        serviceRelative.showSuccess()
//                        return false
//                    }
//
//                })
//                .into(img_relative)
//
//        val serviceLinear = EasyLoad.instance
//                .beginBuilder()
//                .setOnStateChangeListener(object : OnStateChangeListener {
//                    override fun onStateChange(view: View, currentState: BaseState) {
//                        when (currentState) {
//                            is SuccessState -> {
//                                // Logger.d("成功")
//                            }
//                            is GlobalDefaultState -> {
//                                val tvContent = view.findViewById<TextView>(R.id.tv_content)
//                                tvContent.text = "Linear的默认"
//                            }
//                        }
//                    }
//
//                })
//                .inject(img_linear)
//
//        Glide.with(this)
//                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1578914817343&di=9accd7838f2ce5b2eefffce10e6b4537&imgtype=0&src=http%3A%2F%2Fbpic.588ku.com%2Fback_pic%2F05%2F13%2F21%2F08599e2bfd77e74.jpg")
//                .listener(object : RequestListener<Drawable> {
//
//                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
//                        Logger.d(e?.message)
//                        return false
//                    }
//
//                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
//                        Logger.d("线性布局的加载成功")
//                        serviceLinear.showSuccess()
//                        return false
//                    }
//
//                })
//                .into(img_linear)

    }
}