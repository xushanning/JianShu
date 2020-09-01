package com.xu.commonlib.utlis.extention

import androidx.lifecycle.viewModelScope
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.http.ApiException
import com.xu.commonlib.http.BaseResponse
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
            block()
        }.onSuccess {
            if (it.isSuccess()) {
                success(it.getResData())
            } else throw ApiException(it.getResCode(), it.getResMsg())
        }.onFailure {

        }
    }
}