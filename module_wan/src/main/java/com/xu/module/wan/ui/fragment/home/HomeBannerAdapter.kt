package com.xu.module.wan.ui.fragment.home

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.xu.commonlib.utlis.extention.load
import com.xu.module.wan.R
import com.xu.module.wan.bean.BannerBean
import com.youth.banner.adapter.BannerAdapter
import com.youth.banner.util.BannerUtils

/**
 * 首页banner适配器
 */
class HomeBannerAdapter(data: MutableList<BannerBean>) :
    BannerAdapter<BannerBean, HomeBannerAdapter.ImageHolder>(data) {

    override fun onCreateHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        return ImageHolder(
            BannerUtils.getView(parent, R.layout.w_banner_home)
        )
    }


    override fun onBindView(
        holder: ImageHolder,
        data: BannerBean,
        position: Int,
        size: Int
    ) {
        holder.imageView?.load(data.imagePath)
    }

    class ImageHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageView: ImageView? = null

        init {
            this.imageView = view as ImageView
        }
    }
}