package com.xu.module.video.ui.activity.main

import com.xu.commonlib.mvp.BaseModel
import com.xu.module.video.http.VideoApi
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author 言吾許
 */
class MainModel @Inject constructor() : BaseModel(), IMainContract.IMainModel {
    @Inject
    lateinit var api: VideoApi

    override fun getShareHtml(shareUrl: String): Observable<String> {
        return api.getVideoHtml(shareUrl)
    }

}