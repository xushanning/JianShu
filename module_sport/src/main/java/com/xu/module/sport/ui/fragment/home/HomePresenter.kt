package com.xu.module.sport.ui.fragment.home

import com.orhanobut.logger.Logger
import com.xu.commonlib.mvp.BasePresenter
import com.xu.commonlib.utlis.TimeUtil
import com.xu.commonlib.utlis.TransformUtil
import java.util.*
import javax.inject.Inject

/**
 * @author 言吾許
 */
class HomePresenter @Inject constructor() :
        BasePresenter<IHomeContract.IHomeView, IHomeContract.IHomeModel>(),
        IHomeContract.IHomePresenter {
    override fun getCurrentMonthSportStatistics(sportType: Int) {
        val statisticsDis = mModel.getCurrentMonthSportStatistics(sportType, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH) + 1)
                .compose(TransformUtil.defaultFlowableSchedulers())
                .compose(mView.bindToLife())
                .subscribe({
                    var sportMileage = 0.0f
                    var sportTime = 0L
                    it.forEach { item ->
                        sportMileage += item.sportMileage
                        sportTime += item.sportTime
                    }

                    mView.loadCurrentMonthSportStatistics(
                            sportMileage.toString(),
                            "1",
                            TimeUtil.getTime(sportTime)
                    )
                }, { Logger.d(it.message) })
        mCompositeDisposable.add(statisticsDis)
    }
}