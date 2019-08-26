package com.xu.module.sport.ui.activity.historylist;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.xu.commonlib.db.entity.TrajectoryEntity;
import com.xu.commonres.sticky.FullSpanUtil;
import com.xu.module.sport.R;
import com.xu.module.sport.beans.HistoryBean;
import com.xu.module.sport.beans.HistoryHeadBean;
import com.xu.module.sport.beans.StickyHeadEntity;

import java.util.List;


/**
 *
 */
public class StockAdapter extends RecyclerViewAdapter<HistoryBean, StickyHeadEntity<HistoryBean>> {


    public StockAdapter(List<StickyHeadEntity<HistoryBean>> data) {
        super(data);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        FullSpanUtil.onAttachedToRecyclerView(recyclerView, this, TYPE_STICKY_HEAD);
    }

    @Override
    public void onViewAttachedToWindow(RecyclerViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        FullSpanUtil.onViewAttachedToWindow(holder, this, TYPE_STICKY_HEAD);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        switch (viewType) {
            case TYPE_STICKY_HEAD:
                return R.layout.s_item_header;
            case TYPE_DATA:
                return R.layout.s_item_data;
            default:
                return 0;
        }
    }

    @Override
    public void bindData(RecyclerViewHolder holder, int viewType, int position, HistoryBean item) {
        int type = holder.getItemViewType();
        switch (type) {
            case TYPE_STICKY_HEAD:
                HistoryHeadBean headBean = item.getHeadBean();
                holder.setText(R.id.tv_mileage, headBean.getMonthMileage())
                        .setText(R.id.tv_sport_duration, headBean.getMonthDuration())
                        .setText(R.id.tv_sport_count, headBean.getMonthCount())
                        .setText(R.id.tv_sport_heat, headBean.getMonthHeat());
                break;
            case TYPE_DATA:
                TrajectoryEntity dataBean = item.getDataBean();
                holder.setText(
                        R.id.tv_sport_date,
                        holder.itemView.getContext().getString(
                                R.string.s_sport_date,
                                String.valueOf(dataBean.getYear()),
                                formatDate(dataBean.getMonth()),
                                formatDate(dataBean.getDay()),
                                //todo 先写死上午 重构此adapter为kotlin
                                "上午",
                                //todo 默认骑车 将来待运动开始选择方式后，再做
                                "骑车"
                        )
                ).setText(R.id.tv_mileage, String.valueOf(dataBean.getSportMileage()))
                        .setText(R.id.tv_heat, String.valueOf(dataBean.getHeat()))
                        //todo 下面这两个 写死吧先
                        .setText(R.id.tv_comment_count, "1")
                        .setText(R.id.tv_appreciate, "6");
                break;
            default:
                break;

        }
    }

    private String formatDate(int date) {
        if (date < 10) {
            return "0" + date;
        } else {
            return String.valueOf(date);
        }
    }


    private int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


}
