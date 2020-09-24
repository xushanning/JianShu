package com.xu.module.wan.ui.activity.web

import android.os.CountDownTimer
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.just.agentweb.AgentWeb
import com.orhanobut.logger.Logger
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.base.BaseActivity
import com.xu.module.wan.bean.ArticleItemBean
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WActivityWebBinding
import com.xu.module.wan.viewmodel.ReadHistoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.w_activity_web.*

/**
 * 加载WebView
 */
@Route(path = ARouterPath.web)
@AndroidEntryPoint
class WebActivity(
    override val layoutId: Int = R.layout.w_activity_web,
    override val variableId: Int = BR.vm
) : BaseActivity<WebViewModel, WActivityWebBinding>() {

    @Autowired(name = "url")
    @JvmField
    var url: String? = null

    @Autowired(name = "title")
    @JvmField
    var title: String? = null

    @Autowired(name = "bean")
    @JvmField
    var bean: ArticleItemBean? = null

    /**
     * 来源
     */
    @Autowired(name = "source")
    @JvmField
    var source: Int? = 0

    private lateinit var web: AgentWeb

    /**
     * 阅读历史ViewModel
     */
    private val readHistoryViewModel: ReadHistoryViewModel by viewModels()

    override fun initView(mDataBinding: WActivityWebBinding) {
        initWeb()
        tb_web.run {
            Logger.d(this@WebActivity.title)
            this@WebActivity.setSupportActionBar(this)
            setBackgroundColor(ContextCompat.getColor(this@WebActivity, R.color.res_blue))
            supportActionBar?.title = this@WebActivity.title
            setNavigationIcon(R.drawable.res_back_white)
            setNavigationOnClickListener {
                finish()
            }
        }
    }

    override fun initData() {
        //五秒后，算作阅读
        object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                if (bean != null) {
                    Logger.d("开始保存阅读记录")
                    readHistoryViewModel.saveHistory(bean!!)
                }
            }

        }.start()
    }

    private fun initWeb() {
        web = AgentWeb.with(this)
            .setAgentWebParent(ll_container, LinearLayout.LayoutParams(-1, -1))
            .useDefaultIndicator()
            .createAgentWeb()
            .ready()
            .go(url)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.w_menu_web, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.web_share -> {
                //分享

            }
            R.id.web_browser -> {
                //用浏览器打开

            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onPause() {
        web.webLifeCycle.onPause()
        super.onPause()
    }

    override fun onResume() {
        web.webLifeCycle.onResume()
        super.onResume()
    }

    override fun onDestroy() {
        web.webLifeCycle.onDestroy()
        super.onDestroy()
    }
}