package com.xu.commonlib.utlis.extention

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.http.ApiException
import com.xu.commonlib.http.BaseResponse
import com.xu.commonlib.http.ErrorHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * @author 许 on 2020/8/29.
 */


fun <T> BaseViewModel.request(
    block: suspend () -> BaseResponse<T>,
    success: (T) -> Unit,
    error: (ApiException) -> Unit,
    showLoading: Boolean = true,
    msg: String = "正在加载.."
): Job {
    return viewModelScope.launch {
        runCatching {
            if (showLoading) {
                showDialog.postValue(msg)
            }
            block()
        }.onSuccess {
            if (showLoading) {
                dismissDialog.postValue(true)
            }
            runCatching {
                if (it.isSuccess() && it.getResData() != null) {
                    success(it.getResData()!!)
                } else {
                    throw ApiException(it.getResCode(), it.getResMsg(), null)
                }
            }.onFailure {
                error(ErrorHandler.handleError(it))
            }
        }.onFailure {
            if (showLoading) {
                dismissDialog.postValue(true)
            }
            error(ErrorHandler.handleError(it))
        }
    }
}

/**
 * success不带有返回值的，因为一些接口对
 * 返回值不感兴趣，并且这种接口很多时候返回null
 * 因此用这个。。不友好。。
 */
fun <T> BaseViewModel.requestByNoResult(
    block: suspend () -> BaseResponse<T>,
    success: () -> Unit,
    error: (ApiException) -> Unit,
    showLoading: Boolean = true,
    msg: String = "正在加载.."
): Job {
    return viewModelScope.launch {
        runCatching {
            if (showLoading) {
                showDialog.postValue(msg)
            }
            block()
        }.onSuccess {
            if (showLoading) {
                dismissDialog.postValue(true)
            }
            runCatching {
                if (it.isSuccess()) {
                    success()
                } else {
                    throw ApiException(it.getResCode(), it.getResMsg(), null)
                }
            }.onFailure {
                Logger.d(it.message)
                error(ErrorHandler.handleError(it))
            }
        }.onFailure {
            if (showLoading) {
                dismissDialog.postValue(false)
            }
            error(ErrorHandler.handleError(it))
        }
    }
}

fun <T> BaseViewModel.request(
    block: suspend () -> BaseResponse<T>,
    result: MutableLiveData<T>,
    error: (ApiException) -> Unit,
    showLoading: Boolean = true,
    msg: String = "正在加载.."
): Job {
    return viewModelScope.launch {
        runCatching {
            if (showLoading) {
                showDialog.postValue(msg)
            }
            block()
        }.onSuccess {
            if (showLoading) {
                dismissDialog.postValue(true)
            }
            runCatching {
                if (it.isSuccess()) {
                    result.postValue(it.getResData())
                } else {
                    throw ApiException(it.getResCode(), it.getResMsg(), null)
                }
            }.onFailure {
                error(ErrorHandler.handleError(it))
            }
        }.onFailure {
            if (showLoading) {
                dismissDialog.postValue(true)
            }
            error(ErrorHandler.handleError(it))
        }
    }
}