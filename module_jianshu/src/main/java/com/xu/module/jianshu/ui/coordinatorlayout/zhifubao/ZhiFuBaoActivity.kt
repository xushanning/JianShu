package com.xu.module.jianshu.ui.coordinatorlayout.zhifubao

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.AppBarLayout
import com.jaeger.library.StatusBarUtil
import com.xu.commonlib.base.BaseActivity
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.module.jianshu.R
import com.xu.module.jianshu.ui.coordinatorlayout.CoordinatorAdapter
import kotlinx.android.synthetic.main.j_activity_zhi_fu_bao.*
import kotlin.math.abs

/**
 * 仿支付宝首页
 */
class ZhiFuBaoActivity : BaseActivity(), AppBarLayout.OnOffsetChangedListener {
    private val quickAdapter = CoordinatorAdapter(ArrayList())
    override fun setLayoutId(): Int {
        return R.layout.j_activity_zhi_fu_bao
    }

    override fun initView(savedInstanceState: Bundle?) {
        rv_content.layoutManager = LinearLayoutManager(this)
        rv_content.adapter = quickAdapter
        abl_zfb.addOnOffsetChangedListener(this)
        //扫一扫
        img_open_scan.singleClick {
            showToast("扫一扫")
        }
        //付钱
        img_open_pay.singleClick {
            showToast("付钱")
        }
        //收钱
        img_open_toll.singleClick {
            showToast("收钱")
        }
        //卡包
        img_open_card.singleClick {
            showToast("卡包")
        }
        //个人中心
        img_person_center.singleClick {
            showToast("个人中心")
        }
        //增加
        img_add.singleClick {
            showToast("增加")
        }
        //语音
        img_microphone.singleClick {
            showToast("语音")
        }
        //搜索
        v_search.singleClick {
            showToast("搜索")
        }
        //扫一扫
        img_close_scan.singleClick {
            showToast("扫一扫")
        }
        //付钱
        img_close_pay.singleClick {
            showToast("付钱")
        }
        //收钱
        img_close_toll.singleClick {
            showToast("收钱")
        }
        //搜索
        img_close_card.singleClick {
            showToast("搜索")
        }
    }

    override fun setStatusBar() {
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.j_zfb_bg), 0)
    }

    override fun initData() {
        val data = ArrayList<String>()
        for (i in 1..100) {
            data.add(i.toString())
        }
        quickAdapter.setNewData(data)
    }

    override fun onOffsetChanged(p0: AppBarLayout, p1: Int) {
        val maxScrollRange = p0.totalScrollRange
        val offset = abs(p1)
        if (offset <= maxScrollRange / 2) {
            cl_1.visibility = View.VISIBLE
            cl_2.visibility = View.GONE
            val scale: Float = offset.toFloat() / (maxScrollRange / 2)
            val alpha: Int = (255 * scale).toInt()
            v_bg1.setBackgroundColor(Color.argb(alpha, 25, 131, 209))

        } else {
            cl_2.visibility = View.VISIBLE
            cl_1.visibility = View.GONE
            val scale = (maxScrollRange - offset).toFloat() / (maxScrollRange / 2)
            val alpha = (255 * scale).toInt()
            v_bg2.setBackgroundColor(Color.argb(alpha, 25, 131, 209))
        }
    }
}