package com.xu.module.sport.ui.activity.history

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.tabs.TabLayout
import com.xu.commonlib.base.BaseMvpActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.commonlib.utlis.extention.singleClick
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
        tl_year.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(p0: TabLayout.Tab) {
                mPresenter.getSportMonthByYear(yearList!![p0.position])
            }

            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

        })

        //月份选择
        tl_month.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {

            }

        })
    }

    override fun loadSportYear(yearList: List<Int>) {
        this.yearList = yearList
        yearList.forEach {
            tl_year.addTab(tl_year.newTab().setText(it.toString()))
        }
        //todo 这里并没有移动到最后去
        tl_year.getTabAt(yearList.size - 1)?.select()
        tl_year.setScrollPosition(tl_year.selectedTabPosition, 0f, true)

    }


}