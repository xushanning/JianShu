package com.xu.commonlib.utlis

import io.reactivex.FlowableTransformer
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author 言吾許
 */
object TransformUtil {
    fun <T> defaultSchedulers(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream ->
            upstream.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
        }
    }

    fun <T> defaultFlowableSchedulers(): FlowableTransformer<T, T> {
        return FlowableTransformer { upstream ->
            upstream.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
        }
    }
}