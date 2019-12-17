package com.xu.module.jianshu.ui.coordinatorlayout.alipay

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.orhanobut.logger.Logger
import com.xu.module.jianshu.R

/**
 * item adapter
 */
class ZfbItemQuickAdapter(data: List<ItemBean>) : BaseQuickAdapter<ItemBean, BaseViewHolder>(R.layout.j_item_alipay, data) {
    override fun convert(helper: BaseViewHolder, item: ItemBean) {
        try {
            helper.setText(R.id.tv_item_name, item.itemName)
                    .setImageResource(R.id.img_icon, mContext.resources.getIdentifier(item.iconName, "drawable", mContext.packageName))
        } catch (e: Exception) {
            Logger.d(e.message)
        }
    }
}