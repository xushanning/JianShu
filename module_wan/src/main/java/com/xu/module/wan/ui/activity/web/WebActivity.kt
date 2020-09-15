package com.xu.module.wan.ui.activity.web

import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.just.agentweb.AgentWeb
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.mvvm.BaseVmActivity
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WActivityWebBinding
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
) : BaseVmActivity<WebViewModel, WActivityWebBinding>() {

    @Autowired(name = "url")
    @JvmField
    var url: String? = null

    @Autowired(name = "title")
    @JvmField
    var title: String? = null

    private lateinit var web: AgentWeb

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