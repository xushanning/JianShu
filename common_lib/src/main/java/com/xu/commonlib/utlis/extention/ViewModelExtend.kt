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
    showLoading: Boolean = true
): Job {
    return viewModelScope.launch {
        runCatching {
            if (showLoading) {

            }
            block()
        }.onSuccess {
            //dismiss dialog
            runCatching {
                //todo 这里建立在如果成功（code==1），那么data一定非null，如果code==1，并且出现了data==null，就会crash
                if (it.isSuccess() && it.getResData() != null) {
                    success(it.getResData()!!)
                } else {
                    throw ApiException(it.getResCode(), it.getResMsg(), null)
                }
            }.onFailure {
                error(ErrorHandler.handleError(it))
            }
        }.onFailure {
            Logger.d(it.message)
            error(ErrorHandler.handleError(it))
        }
    }
}

fun <T> BaseViewModel.request(
    block: suspend () -> BaseResponse<T>,
    result: MutableLiveData<T>,
    error: (ApiException) -> Unit,
    showLoading: Boolean = true
): Job {
    return viewModelScope.launch {
        runCatching {
            if (showLoading) {

            }
            block()
        }.onSuccess {
            //dismiss dialog
            runCatching {
                //todo 这里建立在如果成功（code==1），那么data一定非null，如果code==1，并且出现了data==null，就会crash
                if (it.isSuccess() && it.getResData() != null) {
                    result.postValue(it.getResData())
                } else {
                    throw ApiException(it.getResCode(), it.getResMsg(), null)
                }
            }.onFailure {
                error(ErrorHandler.handleError(it))
            }
        }.onFailure {
            Logger.d(it.message)
            error(ErrorHandler.handleError(it))
        }
    }
}