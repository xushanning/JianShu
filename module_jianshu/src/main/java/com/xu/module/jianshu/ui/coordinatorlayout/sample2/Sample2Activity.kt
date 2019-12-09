package com.xu.module.jianshu.ui.coordinatorlayout.sample2

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.base.BaseActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.module.jianshu.R
import com.xu.module.jianshu.ui.coordinatorlayout.CoordinatorAdapter
import kotlinx.android.synthetic.main.j_activity_coordinator_sample2.*

@Route(path = ARouterPath.jianshuCoordinatorSample2)
class Sample2Activity : BaseActivity() {
    private val quickAdapter = CoordinatorAdapter(ArrayList())
    override fun setLayoutId(): Int {
        return R.layout.j_activity_coordinator_sample2
    }

    override fun initView(savedInstanceState: Bundle?) {
        rv_list.layoutManager = LinearLayoutManager(this)
        rv_list.adapter = quickAdapter
    }

    override fun initData() {
        val data = ArrayList<String>()
        for (i in 1..100) {
            data.add(i.toString())
        }
        quickAdapter.setNewData(data)
    }
}