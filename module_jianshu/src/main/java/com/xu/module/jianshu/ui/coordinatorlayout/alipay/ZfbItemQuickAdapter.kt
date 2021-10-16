package com.xu.module.jianshu.ui.coordinatorlayout.alipay

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.orhanobut.logger.Logger
import com.xu.module.jianshu.R

/**
 * item adapter
 */
class ZfbItemQuickAdapter(data: MutableList<ItemBean>) :
    BaseQuickAdapter<ItemBean, BaseViewHolder>(R.layout.j_item_alipay, data) {
    override fun convert(helper: BaseViewHolder, item: ItemBean) {
        try {
            helper.setText(R.id.tv_item_name, item.itemName)
                .setImageResource(
                    R.id.img_icon,
                    context.resources.getIdentifier(item.iconName, "drawable", context.packageName)
                )
        } catch (e: Exception) {
            Logger.d(e.message)
        }
    }
}