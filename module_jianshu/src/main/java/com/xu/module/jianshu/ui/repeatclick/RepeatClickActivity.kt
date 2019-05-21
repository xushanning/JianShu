package com.xu.module.jianshu.ui.repeatclick

import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.BaseActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.commonlib.utlis.extention.singleChildItemClick
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.commonlib.utlis.extention.singleItemClick
import com.xu.module.jianshu.R
import kotlinx.android.synthetic.main.j_activity_repeat_click.*

/**
 * @author 言吾許
 * 防重点测试
 */
@Route(path = ARouterPath.jianshuRepeatClick)
class RepeatClickActivity : BaseActivity() {
    private var viewClickCount = 0

    private var itemClickCount = 0

    private var childClickCount = 0


    override fun setLayoutId(): Int {
        return R.layout.j_activity_repeat_click
    }

    override fun initView() {
        tv_view_click_count.text = getString(R.string.j_view_click_count, 0)
        tv_recycler_click_count.text = getString(R.string.j_recycler_click_count, 0)
        tv_child_repeat_click.text = getString(R.string.j_child_click_count, 0)
        bt_repeat_click.singleClick {
            viewClickCount++
            tv_view_click_count.text = getString(R.string.j_view_click_count, viewClickCount)
        }

        val data = ArrayList<String>().apply {
            add("1")
            add("2")
            add("3")
        }

        val quickAdapter = RepeatQuickAdapter(data)
        rv_repeat_click.adapter = quickAdapter
        rv_repeat_click.layoutManager = LinearLayoutManager(this)

        //item防重点击
        quickAdapter.singleItemClick {
            itemClickCount++
            tv_recycler_click_count.text = getString(R.string.j_recycler_click_count, itemClickCount)
        }

        //子view防重点击
        quickAdapter.singleChildItemClick { position, viewId ->
            Logger.d("item位置:$position")
            Logger.d("viewID:$viewId")
            childClickCount++
            tv_child_repeat_click.text = getString(R.string.j_child_click_count, childClickCount)
        }

    }
}