package com.xu.module.sport.ui.fragment.home

import com.xu.commonlib.mvp.BasePresenter
import javax.inject.Inject

/**
 * @author 言吾許
 */
class HomePresenter @Inject constructor() : BasePresenter<IHomeContract.IHomeView, IHomeContract.IHomeModel>(),
    IHomeContract.IHomePresenter {
}