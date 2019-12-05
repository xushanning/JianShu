package com.xu.module.video.ui.fragment.completed

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.base.BaseMvpFragment
import com.xu.commonlib.constant.ARouterPath
import com.xu.module.video.R
import kotlinx.android.synthetic.main.v_fragment_completed.*

/**
 * @author 言吾許
 * 已经完成fragment
 */
@Route(path = ARouterPath.videoCompleted)
class CompletedFragment : BaseMvpFragment<ICompletedContract.ICompletedView, ICompletedContract.ICompletedPresenter>(), ICompletedContract.ICompletedView {
    private val adapter = CompleteQuickAdapter(ArrayList())

    override fun setLayoutId(): Int {
        return R.layout.v_fragment_completed
    }

    override fun initView(view: View) {
        rv_complete.adapter = adapter
        rv_complete.layoutManager = LinearLayoutManager(context)
    }

    override fun initData() {
        val data = ArrayList<String>()
        for (i in 0..100) {
            data.add(i.toString())
        }
        adapter.setNewData(data)
    }
}