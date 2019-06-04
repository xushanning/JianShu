package com.xu.module.sport.ui.fragment.sport

import com.xu.commonlib.mvp.BasePresenter
import javax.inject.Inject

/**
 * @author 言吾許
 */
class SportPresenter @Inject constructor() : BasePresenter<ISportContract.ISportView, ISportContract.ISportModel>(),
    ISportContract.ISportPresenter {
}