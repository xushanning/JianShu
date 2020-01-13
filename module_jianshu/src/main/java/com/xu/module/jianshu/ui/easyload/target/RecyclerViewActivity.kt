package com.xu.module.jianshu.ui.easyload.target

import android.app.Activity
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.SparseArray
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.orhanobut.logger.Logger
import com.xu.module.easyload.EasyLoad
import com.xu.module.easyload.service.ILoadService
import com.xu.module.jianshu.R
import kotlinx.android.synthetic.main.j_activity_easy_load_recycler.*

/**
 * list
 */
class RecyclerViewActivity : Activity() {
    private val adapter = RecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.j_activity_easy_load_recycler)
        val service = EasyLoad.instance
                .beginBuilder()
                .inject(rv_content)
        rv_content.layoutManager = LinearLayoutManager(this)
        rv_content.adapter = adapter
        Handler(Looper.getMainLooper()).postDelayed(
                {
                    service.showSuccess()
                    setData()
                }, 2000)

    }

    private fun setData() {
        val data = ArrayList<String>()
        for (i in 0..100) {
            data.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=4177056998,326509749&fm=26&gp=0.jpg")
        }
        adapter.setNewData(data)
    }


    class RecyclerViewAdapter : BaseQuickAdapter<String, BaseViewHolder>(R.layout.j_item_easy_load_recycler) {
        private val list = SparseArray<ILoadService>()
        override fun convert(helper: BaseViewHolder, item: String) {
            val imgContent = helper.getView<ImageView>(R.id.img_content)
            Logger.d(helper.layoutPosition)
            Logger.d(list.get(helper.layoutPosition) == null)
            if (list.get(helper.layoutPosition) == null) {
                val service = EasyLoad.instance
                        .beginBuilder()
                        .inject(imgContent)
                list.put(helper.layoutPosition, service)
                Glide.with(mContext)
                        .load(item)
                        .listener(object : RequestListener<Drawable> {

                            override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                                Logger.d(e?.message)
                                return false
                            }

                            override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                                Logger.d("加载成功")
                                service.showSuccess()
                                return false
                            }

                        })
                        .into(imgContent)
            }
        }
    }
}