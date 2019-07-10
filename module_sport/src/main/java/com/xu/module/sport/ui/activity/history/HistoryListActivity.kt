package com.xu.module.sport.ui.activity.history

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.BaseMvpActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.commonlib.db.entity.TrajectoryEntity
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.commonlib.utlis.extention.tabSelected
import com.xu.module.sport.R
import kotlinx.android.synthetic.main.s_activity_history_trajectory.*


/**
 * @author 言吾許
 * 历史轨迹界面
 */
@Route(path = ARouterPath.sportHistoryList)
class HistoryListActivity :
    BaseMvpActivity<IHistoryListContract.IHistoryListView, IHistoryListContract.IHistoryListPresenter>(),
    IHistoryListContract.IHistoryListView {

    private var yearList: List<Int>? = null

    private var monthList: List<Int>? = null

    private var yearPosition = 0


    override fun setLayoutId(): Int {
        return R.layout.s_activity_history_trajectory
    }

    override fun initView(savedInstanceState: Bundle?) {
        img_back.singleClick {
            finish()
        }
        initTabLayout()
        mPresenter.getSportYear()
    }

    private fun initTabLayout() {
        //todo 用自定义view实现文字的放大效果
        //年选择
        tl_year.tabSelected {
            Logger.d("年份选择了")
            yearPosition = it
            mPresenter.getSportMonthByYear(yearList!![it])
        }
        //月份选择
        tl_month.tabSelected {
            mPresenter.getSportHistoryByMonth(yearList!![yearPosition], monthList!![it])
        }

    }

    override fun loadSportYear(yearList: List<Int>) {
        this.yearList = yearList
        yearPosition = yearList.size - 1
        yearList.forEach {
            tl_year.addTab(tl_year.newTab().setText(it.toString()))
        }
        //todo 这里并没有移动到最后去
        tl_year.getTabAt(yearList.size - 1)?.select()
        tl_year.setScrollPosition(yearList.size - 1, 0f, true)
        val classZ = tl_year.javaClass
        //https://blog.csdn.net/aigestudio/article/details/47155769
//        try {
//            val animateToTab = classZ.getDeclaredMethod("animateToTab",)
//        } catch (e: Exception) {
//
//        }

    }

    override fun loadSportMonth(monthList: List<Int>) {
        Logger.d("加载月份")
        this.monthList = monthList
        mPresenter.getSportHistoryByMonth(yearList!![yearPosition], monthList[monthList.size - 1])
        tl_month.removeAllTabs()
        monthList.forEach {
            tl_month.addTab(tl_month.newTab().setText(it.toString()))
        }
    }

    override fun loadSportHistoryList(historyList: List<TrajectoryEntity>) {

    }
}