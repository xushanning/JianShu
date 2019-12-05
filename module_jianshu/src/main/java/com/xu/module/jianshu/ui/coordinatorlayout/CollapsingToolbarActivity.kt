package com.xu.module.jianshu.ui.coordinatorlayout

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.base.BaseActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.module.jianshu.R

@Route(path = ARouterPath.jianshuCollapsing)
class CollapsingToolbarActivity : BaseActivity() {
    private val quickAdapter = CoordinatorAdapter(ArrayList())
    override fun setLayoutId(): Int {
        return R.layout.j_activity_collapsing
    }

    override fun initView(savedInstanceState: Bundle?) {
//        rv_coordinator.layoutManager = LinearLayoutManager(this)
//        rv_coordinator.adapter = quickAdapter
    }

    override fun initData() {
        val data = ArrayList<String>()
        for (i in 1..100) {
            data.add(i.toString())
        }
        quickAdapter.setNewData(data)
    }

}