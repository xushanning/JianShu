package com.xu.module.jianshu.ui.coordinatorlayout.sample1

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.xu.commonlib.base.BaseActivity
import com.xu.module.jianshu.R
import com.xu.module.jianshu.ui.coordinatorlayout.CoordinatorAdapter
import kotlinx.android.synthetic.main.j_activity_text_recycler.*

/**
 *
 * 地址：https://www.jianshu.com/p/b987fad8fcb4
 */
class TextRecyclerActivity : BaseActivity() {
    private val quickAdapter = CoordinatorAdapter(ArrayList())
    override fun setLayoutId(): Int {
        return R.layout.j_activity_text_recycler
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