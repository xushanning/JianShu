package com.xu.module.video.ui.activity.main

import com.orhanobut.logger.Logger
import com.xu.commonlib.mvp.BasePresenter
import com.xu.commonlib.utlis.TransformUtil
import com.xu.module.video.bean.VideoInfoBean
import com.xu.module.video.http.ApiException
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import java.util.*
import java.util.regex.Pattern
import javax.inject.Inject

/**
 * @author 言吾許
 */
class MainPresenter @Inject constructor() :
        BasePresenter<IMainContract.IMainView, IMainContract.IMainModel>(),
        IMainContract.IMainPresenter {
    companion object {
        /**
         * 抖音的分享头
         */
        private const val DOU_YIN_SHARE = "v.douyin.com"

    }

    /**
     * 分享url的正则表达式
     */
    private val urlPattern =
            Pattern.compile("(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]")
    /**
     * 抖音视频地址：以playAddr:"开头，以"结尾的
     */
    private val douYinVideoPattern = Pattern.compile("(?<=playAddr: \").*?(?=\")")
    /**
     * 抖音视频封面pattern:以cover: "开头（有空格）,以"结尾的
     */
    private val douYinVideoCoverPattern = Pattern.compile("(?<=cover: \").*?(?=\")")
    /**
     * 抖音视频标题pattern:以<p class="desc">
     */
    private val douYinVideoTitlePattern = Pattern.compile("(?<=<p class=\"desc\">).*?(?=</p>)")


    override fun checkShareUrl(shareUrl: CharSequence?) {
        if (shareUrl == null) {
            return
        }
        val shareUrlDis = Observable
                .create(ObservableOnSubscribe<String> {
                    val urlPattern = urlPattern.matcher(shareUrl.toString())
                    if (shareUrl.contains(DOU_YIN_SHARE) && urlPattern.find()) {
                        //group（0）就是指的整个串
                        it.onNext(urlPattern.group(0))
                    } else {
                        throw ApiException("暂不支持类型")
                    }
                })
                .flatMap {
                    mModel.getShareHtml(it)
                }
                .map {
                    Logger.d(it)
                    val videoPattern = douYinVideoPattern.matcher(it)
                    val coverPattern = douYinVideoCoverPattern.matcher(it)
                    val titlePattern = douYinVideoTitlePattern.matcher(it)
                    var coverUrl = ""
                    if (coverPattern.find()) {
                        coverUrl = coverPattern.group(0)
                    }
                    val title = if (titlePattern.find()) {
                        titlePattern.group(0)
                    } else {
                        //如果html中匹配不到title，随机生成一个唯一的id
                        val s = UUID.randomUUID().toString()
                        s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24)
                    }
                    if (videoPattern.find()) {
                        val videoUrl = videoPattern.group(0)
                        VideoInfoBean(title, videoUrl, coverUrl)
                    } else {
                        throw ApiException("解析错误")
                    }
                }
                .compose(TransformUtil.defaultSchedulers())
                .compose(mView.bindToLife())
                .subscribe({
                    mView.showDownloadDialog(it.videoCoverUrl, it.videoUrl, it.title)
                }, { Logger.d(it.message) })
        mCompositeDisposable.add(shareUrlDis)

    }
}