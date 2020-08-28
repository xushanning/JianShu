package com.xu.commonlib.mvp

import androidx.lifecycle.LifecycleCoroutineScope

/**
 * @author 言吾許
 */
interface IPresenter<in T : IView> {
    fun attachView(mView: T, lifecycleScope: LifecycleCoroutineScope)
    fun detachView()
}