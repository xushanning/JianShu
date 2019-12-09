package com.xu.module.jianshu.ui.coordinatorlayout.sample3

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.base.BaseFragment
import com.xu.commonlib.constant.ARouterPath
import com.xu.module.jianshu.R
import com.xu.module.jianshu.ui.coordinatorlayout.CoordinatorAdapter
import kotlinx.android.synthetic.main.j_fragment_coordinator_sample3.*

@Route(path = ARouterPath.jianshuCoordinatorSample3Fragment)
class CoordinatorFragment : BaseFragment() {
    private val quickAdapter = CoordinatorAdapter(ArrayList())
    override fun setLayoutId(): Int {
        return R.layout.j_fragment_coordinator_sample3
    }

    override fun initView(view: View) {
        rv_coordinator.layoutManager = LinearLayoutManager(context)
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