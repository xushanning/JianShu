package com.xu.commonlib.utlis

import io.reactivex.CompletableTransformer
import io.reactivex.FlowableTransformer
import io.reactivex.ObservableTransformer
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author 言吾許
 */
object TransformUtil {
    /**
     * 默认Observable线程切换
     */
    fun <T> defaultSchedulers(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream ->
            upstream.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
        }
    }

    /**
     * Flowable线程切换
     */
    fun <T> defaultFlowableSchedulers(): FlowableTransformer<T, T> {
        return FlowableTransformer { upstream ->
            upstream.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
        }
    }

    /**
     * Single线程切换
     */
    fun <T> defaultSingleSchedulers(): SingleTransformer<T, T> {
        return SingleTransformer { upstream ->
            upstream.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
        }
    }

    /**
     * Completable线程切换
     */
    fun defaultCompletableSchedulers(): CompletableTransformer {
        return CompletableTransformer { upstream ->
            upstream.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
        }
    }
}