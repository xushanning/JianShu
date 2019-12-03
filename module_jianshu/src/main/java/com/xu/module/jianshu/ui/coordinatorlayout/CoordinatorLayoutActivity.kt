package com.xu.module.jianshu.ui.coordinatorlayout

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.base.BaseActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.module.jianshu.R
import kotlinx.android.synthetic.main.j_activity_coordinator.*

/**
 * 协调布局
 */
@Route(path = ARouterPath.jianshuCoordinator)
class CoordinatorLayoutActivity : BaseActivity() {
    private var quickAdapter = CoordinatorAdapter(ArrayList())
    override fun setLayoutId(): Int {
        return R.layout.j_activity_coordinator
    }

    override fun initView(savedInstanceState: Bundle?) {
        rv_coordinator.layoutManager = LinearLayoutManager(this)
        rv_coordinator.adapter = quickAdapter
    }

    override fun initData() {
        val data = ArrayList<String>()
        for (i in 1..100) {
            data.add(i.toString())
        }
        quickAdapter.setNewData(data)
    }

}