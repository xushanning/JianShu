package com.xu.module.sport.ui.activity.historylist

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.xu.module.sport.R
import com.xu.module.sport.constant.SportTypeConstant
import java.util.*

/**
 * @author 言吾許
 * 吸附 adapter
 */
class HistoryListAdapter(data: List<HistoryItemEntity>) :
        BaseMultiItemQuickAdapter<HistoryItemEntity, BaseViewHolder>(data) {
    companion object {
        const val TYPE_HEADER = 1
        const val TYPE_DATA = 2
    }

    init {
        addItemType(TYPE_HEADER, R.layout.s_item_header)
        addItemType(TYPE_DATA, R.layout.s_item_data)
    }

    override fun convert(helper: BaseViewHolder, item: HistoryItemEntity) {
        when (item.itemType) {
            TYPE_HEADER -> {
                val headBean = item.headBean!!
                helper.setText(R.id.tv_mileage_name, headBean.monthMileage)
                        .setText(R.id.tv_sport_duration, headBean.monthDuration)
                        .setText(R.id.tv_sport_count, headBean.monthCount)
                        .setText(R.id.tv_sport_heat, headBean.monthHeat)
            }
            TYPE_DATA -> {
                val dataBean = item.trajectoryEntity!!
                helper.setText(R.id.tv_sport_date, mContext.getString(
                        R.string.s_sport_date,
                        formatDate(dataBean.year),
                        formatDate(dataBean.month),
                        formatDate(dataBean.day),
                        getDate(dataBean.startTime),
                        getSportType(dataBean.sportType))
                ).setText(R.id.tv_mileage_name, dataBean.sportMileage.toString())
                        .setText(R.id.tv_heat, dataBean.heat.toString())
                        //todo 下面这两个 写死吧先
                        .setText(R.id.tv_comment_count, "1")
                        .setText(R.id.tv_appreciate, "6")
            }
        }
    }

    private fun formatDate(date: Int): String {
        return when (date) {
            in 0..9 -> "0$date"
            else -> date.toString()
        }
    }

    private fun getDate(startTime: Long): String {
        val date = Calendar.getInstance()
        date.time = Date(startTime)
        return when (date.get(Calendar.HOUR_OF_DAY)) {
            in 7..11 -> mContext.getString(R.string.s_morning)
            in 12..12 -> mContext.getString(R.string.s_noon)
            in 14..18 -> mContext.getString(R.string.s_afternoon)
            in 20..23 -> mContext.getString(R.string.s_night)
            else -> mContext.getString(R.string.s_before_dawn)
        }
    }

    /**
     * 根据数据库的type返回string的运动类型
     */
    private fun getSportType(sportType: Int): String {
        return when (sportType) {
            SportTypeConstant.SPORT_TYPE_BIKE -> {
                mContext.getString(R.string.s_home_sport_type_bike)
            }
            SportTypeConstant.SPORT_TYPE_FOOT -> {
                mContext.getString(R.string.s_home_sport_type_foot)
            }
            SportTypeConstant.SPORT_TYPE_RUN -> {
                mContext.getString(R.string.s_home_sport_type_run)
            }
            else -> {
                ""
            }
        }
    }


}