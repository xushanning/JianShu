package com.xu.commonlib.utlis.extention

import com.xu.commonlib.mvp.IView
import com.xu.commonlib.utlis.TransformUtil
import io.reactivex.Flowable

/**
 * @author 言吾許
 * Rx扩展
 */

/**
 * 默认的绑定线程和声明周期
 */
fun <T> Flowable<T>.flowableTransform(mView: IView): Flowable<T> {
    return this.compose(TransformUtil.defaultFlowableSchedulers())
        .compose(mView.bindToLife())
}