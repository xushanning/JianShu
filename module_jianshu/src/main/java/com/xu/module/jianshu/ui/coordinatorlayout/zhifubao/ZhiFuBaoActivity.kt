package com.xu.module.jianshu.ui.coordinatorlayout.zhifubao

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.xu.commonlib.base.BaseActivity
import com.xu.module.jianshu.R
import com.xu.module.jianshu.ui.coordinatorlayout.CoordinatorAdapter
import kotlinx.android.synthetic.main.j_activity_zhi_fu_bao.*

/**
 * 仿支付宝首页
 */
class ZhiFuBaoActivity : BaseActivity() {
    private val quickAdapter = CoordinatorAdapter(ArrayList())
    override fun setLayoutId(): Int {
        return R.layout.j_activity_zhi_fu_bao
    }

    override fun initView(savedInstanceState: Bundle?) {
        rv_content.layoutManager = LinearLayoutManager(this)
        rv_content.adapter = quickAdapter
    }

    override fun initData() {
        val data = ArrayList<String>()
        for (i in 1..100) {
            data.add(i.toString())
        }
        quickAdapter.setNewData(data)
    }

}