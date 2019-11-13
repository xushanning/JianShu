package com.xu.module.video.ui.activity.main

import com.xu.commonlib.mvp.IModel
import com.xu.commonlib.mvp.IPresenter
import com.xu.commonlib.mvp.IView
import io.reactivex.Observable

/**
 * @author 言吾許
 */
interface IMainContract {
    interface IMainView : IView {
        /**
         * 展示现在的dialog
         */
        fun showDownloadDialog(coverUrl: String, videoUrl: String, title: String)
    }

    interface IMainPresenter : IPresenter<IMainView> {


        /**
         * 匹配分享的url
         */
        fun checkShareUrl(shareUrl: CharSequence?)
    }

    interface IMainModel : IModel {
        /**
         * 获取分享的html代码
         */
        fun getShareHtml(shareUrl: String): Observable<String>
    }
}