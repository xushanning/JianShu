package com.xu.module.video.ui.activity.main

import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.ModalDialog
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.customview.getCustomView
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.google.android.material.tabs.TabLayout
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.BaseMvpActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.commonlib.utlis.extention.load
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.commonlib.utlis.extention.tabSelected
import com.xu.module.video.R
import com.xu.module.video.bean.VideoInfoBean
import kotlinx.android.synthetic.main.v_activity_main.*

/**
 * @author 言吾許
 */
@Route(path = ARouterPath.videoMain)
class MainActivity : BaseMvpActivity<IMainContract.IMainView, IMainContract.IMainPresenter>(),
    IMainContract.IMainView, ClipboardManager.OnPrimaryClipChangedListener {

    private var clipboardManager: ClipboardManager? = null

    override fun setLayoutId(): Int {
        return R.layout.v_activity_main
    }

    override fun initView(savedInstanceState: Bundle?) {
        setSupportActionBar(tb_main)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        initTabLayout()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.v_home_item, menu)
        return true
    }

    override fun initData() {
        mPresenter.checkShareUrl("#在抖音，记录美好生活# http://v.douyin.com/QaLa4w/ 复制此链接，打开【抖音短视频】，直接观看视频！")
    }

    private fun initTabLayout() {
        val fragmentList = ArrayList<Fragment>()
            .apply {
                //已完成
                val completedFragment =
                    ARouter.getInstance().build(ARouterPath.videoCompleted).navigation() as Fragment
                //正在下载
                val downloadingFragment =
                    ARouter.getInstance().build(ARouterPath.videoDownloading).navigation() as Fragment
                add(completedFragment)
                add(downloadingFragment)

            }

        val pagerAdapter = MainPagerAdapter(supportFragmentManager, fragmentList)
        tl_main.setupWithViewPager(vp_main)

        vp_main.adapter = pagerAdapter

        ArrayList<String>()
            .apply {
                add(getString(R.string.v_tab_name_complete))
                add(getString(R.string.v_tab_name_downloading))
            }.forEachIndexed { index, s ->
                val tab = tl_main.getTabAt(index)
                tab?.text = s
            }

        tl_main.tabSelected {
            updateTab(tl_main.getTabAt(it)!!, false)
        }

//        ArrayList<Int>()
//            .apply {
//                add(R.drawable.v_selector_complete)
//                add(R.drawable.v_selector_downloading)
//            }.forEachIndexed { index, i ->
//                val tab = tl_main.getTabAt(index)
//                val view = LayoutInflater.from(this).inflate(R.layout.v_view_main_tab, null)
//                val tvName = view.findViewById<TextView>(R.id.tv_name)
//                val imgTab = view.findViewById<ImageView>(R.id.img_tab)
//                tvName.text = tabNameList[index]
//                if (index == 0) {
//                    tvName.setTextColor(ContextCompat.getColor(this, R.color.v_main_tab_select))
//                }
//                imgTab.setImageResource(i)
//                tab?.customView = view
//            }

        clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        clipboardManager?.addPrimaryClipChangedListener(this)
    }

    private fun updateTab(tab: TabLayout.Tab, isSelect: Boolean) {
        val tvName = tab.customView?.findViewById<TextView>(R.id.tv_name)
        if (isSelect) {
            tvName?.setTextColor(ContextCompat.getColor(this, R.color.v_main_tab_select))
        } else {
            tvName?.setTextColor(ContextCompat.getColor(this, R.color.v_main_tab_un_select))
        }
    }

    override fun onPrimaryClipChanged() {
        val shareUrl = clipboardManager?.primaryClip?.getItemAt(0)?.text
        mPresenter.checkShareUrl(shareUrl)
    }

    override fun showDownloadDialog(videoInfoBean: VideoInfoBean) {
        val downloadDialog = MaterialDialog(this)
            .show {
                customView(
                    R.layout.v_dialog_download,
                    horizontalPadding = false,
                    noVerticalPadding = true
                )
                cancelOnTouchOutside(false)
            }

        val downloadView = downloadDialog.getCustomView()
        val tvVideoName = downloadView.findViewById<TextView>(R.id.tv_video_name)
        val imgClose = downloadView.findViewById<ImageView>(R.id.img_close)
        val tvDownload = downloadView.findViewById<TextView>(R.id.tv_download)
        val imgCover = downloadView.findViewById<ImageView>(R.id.img_cover)
        val tvVideoSource = downloadView.findViewById<TextView>(R.id.tv_video_source)
        imgCover.load(videoInfoBean.videoCoverUrl)
        imgClose.singleClick {
            downloadDialog.dismiss()
        }
        tvDownload.singleClick {
            Logger.d("开始下载")
        }
        tvVideoName.text = videoInfoBean.title
        tvVideoSource.text = getString(R.string.v_video_source, videoInfoBean.videoSource)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showToast("退出吗？")
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onDestroy() {
        super.onDestroy()
        clipboardManager?.removePrimaryClipChangedListener(this)
    }
}