package com.xu.module.jianshu.ui.easyload.target

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.SparseArray
import android.util.SparseBooleanArray
import android.util.SparseIntArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.orhanobut.logger.Logger
import com.xu.module.easyload.EasyLoad
import com.xu.module.jianshu.R
import kotlinx.android.synthetic.main.j_activity_easy_load_recycler.*

/**
 * list
 */
class RecyclerViewActivity : Activity() {
    private val adapter = MyAdapter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.j_activity_easy_load_recycler)
        val service = EasyLoad.instance
                .beginBuilder()
                .inject(rv_content)
        rv_content.layoutManager = GridLayoutManager(this, 2)
        rv_content.adapter = adapter
        Handler(Looper.getMainLooper()).postDelayed(
                {
                    service.showSuccess()
                    setData()
                }, 2000
        )

    }

    private fun setData() {
        val data = ArrayList<String>()
        for (i in 0..100) {
            data.add(String.format("https://www.thiswaifudoesnotexist.net/example-%d.jpg", (Math.random() * 100000).toInt()))
        }
        adapter.setNewData(data)
    }

    class MyAdapter(var context: Context, var data: List<String> = ArrayList()) :
            RecyclerView.Adapter<MyViewHolder>() {

        var result = SparseBooleanArray()

        fun setNewData(data: ArrayList<String>) {
            this.data = data
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view = LayoutInflater.from(context)
                    .inflate(R.layout.j_item_easy_load_recycler, parent, false)
            return MyViewHolder(context, view)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.loadImage(data[position], position, result)
        }

        override fun getItemCount(): Int {
            return data.size
        }

        override fun getItemViewType(position: Int): Int {
            return position
        }
    }

    class MyViewHolder(var context: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var imgContent: ImageView = itemView.findViewById(R.id.img_content)
        private var tvContent: TextView = itemView.findViewById(R.id.tv_content)

        fun loadImage(url: String, position: Int, result: SparseBooleanArray) {
            if (result.get(position)) {
                Glide.with(context)
                        .load(url)
                        .listener(object : RequestListener<Drawable> {

                            override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                                Logger.d(e?.message)
                                return false
                            }

                            override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                                Logger.d("加载成功")
                                return false
                            }

                        })
                        .into(imgContent)
            } else {
                val service = EasyLoad.instance
                        .beginBuilder()
                        .inject(imgContent)
                Glide.with(context)
                        .load(url)
                        .listener(object : RequestListener<Drawable> {

                            override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                                Logger.d(e?.message)
                                return false
                            }

                            override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                                Logger.d("加载成功")
                                result.put(position, true)
                                service.showSuccess()
                                return false
                            }

                        })
                        .into(imgContent)
            }
        }
    }
}