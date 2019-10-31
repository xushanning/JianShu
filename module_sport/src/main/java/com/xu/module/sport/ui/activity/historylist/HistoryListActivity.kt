package com.xu.module.sport.ui.activity.historylist

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.BaseMvpActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.commonlib.utlis.TransformUtil
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.commonlib.utlis.extention.singleItemClick
import com.xu.commonlib.utlis.extention.tabSelected
import com.xu.module.sport.R
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.s_activity_history_trajectory.*
import java.util.concurrent.TimeUnit


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

    private var yearTimeDis: Disposable? = null

    private var quickAdapter = HistoryListAdapter(ArrayList())


    override fun setLayoutId(): Int {
        return R.layout.s_activity_history_trajectory
    }

    override fun initView(savedInstanceState: Bundle?) {
        img_back.singleClick {
            finish()
        }
        initTabLayout()
        initRecyclerView()

    }

    override fun initData() {
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

    private fun initRecyclerView() {
        //吸顶
//        rv_history.addItemDecoration(
//            PinnedHeaderItemDecoration
//                .Builder(HistoryListAdapter.TYPE_HEADER)
//
//                .create()
//        )
        rv_history.adapter = quickAdapter
        rv_history.layoutManager = LinearLayoutManager(this)
        quickAdapter.singleItemClick {
            if (quickAdapter.getItemViewType(it) == HistoryListAdapter.TYPE_DATA) {
                val trajectoryId = quickAdapter.data[it].trajectoryEntity?.trajectoryId
                ARouter.getInstance()
                    .build(ARouterPath.sportHistory)
                    .withString("trajectoryId", trajectoryId)
                    .navigation()

            }
        }
    }

    override fun loadSportYear(yearList: List<Int>) {
        this.yearList = yearList
        yearPosition = yearList.size - 1
        yearList.forEach {
            tl_year.addTab(tl_year.newTab().setText(it.toString()))
        }

        yearTimeDis = Observable.timer(10, TimeUnit.MILLISECONDS)
            .compose(TransformUtil.defaultSchedulers())
            .subscribe({
                tl_year.getTabAt(yearList.size - 1)?.select()
            }, { Logger.d(it.message) })

    }

    override fun loadSportMonth(monthList: List<Int>) {
        Logger.d("加载月份")
        this.monthList = monthList
        mPresenter.getSportHistoryByMonth(yearList!![yearPosition], monthList[monthList.size - 1])
        tl_month.removeAllTabs()
        monthList.forEach {
            tl_month.addTab(tl_month.newTab().setText(it.toString() + "月"))
        }
    }

    override fun loadSportHistoryList(historyList: List<HistoryItemEntity>) {
        quickAdapter.setNewData(historyList)
    }

    override fun onDestroy() {
        super.onDestroy()
        yearTimeDis?.dispose()
    }
}