package com.xu.module.jianshu.ui.coordinatorlayout.alipay

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.appbar.AppBarLayout
import com.jaeger.library.StatusBarUtil
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.xu.commonlib.base.BaseActivity
import com.xu.commonlib.utlis.AssetUtil
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.commonlib.utlis.extention.singleDataItemClick
import com.xu.module.jianshu.R
import kotlinx.android.synthetic.main.j_activity_alipay.*
import kotlinx.android.synthetic.main.j_layout_alipay_content.*
import kotlinx.android.synthetic.main.j_layout_alipay_middle_content.*
import kotlinx.android.synthetic.main.j_layout_alipay_toolbar_collapse.*
import kotlinx.android.synthetic.main.j_layout_alipay_toolbar_normal.*
import kotlin.math.abs

/**
 * 仿支付宝首页
 */
class ZhiFuBaoActivity : BaseActivity(), AppBarLayout.OnOffsetChangedListener {

    private val quickAdapter = ZfbItemQuickAdapter(ArrayList())
    override fun setLayoutId(): Int {
        return R.layout.j_activity_alipay
    }

    override fun initView(savedInstanceState: Bundle?) {
        rv_content.layoutManager = GridLayoutManager(this, 4)
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
        //增加
        img_close_add.singleClick {
            showToast("增加")
        }
        /**
         * 点击事件
         */
        quickAdapter.singleDataItemClick {
            showToast(it.itemName + "被点击")
        }

        val behavior =
            (abl_zfb.layoutParams as CoordinatorLayout.LayoutParams).behavior as AlipayRefreshBehavior
        behavior.setOnRefrehViewActionListener {
            sv_refresh.setDuration(2000)
            sv_refresh.performAnim()
            sv_refresh.postDelayed({
                this@ZhiFuBaoActivity.runOnUiThread {
                    behavior.stopPin()
                    sv_refresh.cancelAnim()
                }
            }, 2000)
        }
    }

    override fun setStatusBar() {
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.j_zfb_bg), 0)
    }

    override fun initData() {
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, ItemBean::class.java)
        val adapter = moshi.adapter<List<ItemBean>>(type)
//        val itemData: MutableList<ItemBean> =
//            adapter.fromJson(AssetUtil.getAssetJson("zfbConfig.json"))
//        quickAdapter.setNewData(itemData)
    }

    override fun onOffsetChanged(p0: AppBarLayout, p1: Int) {
        val offset = abs(p1)
        val height = cl_normal.height + include_content.height * 7 / 10f

        when {
            offset <= height / 2 -> {
                cl_normal.visibility = View.VISIBLE
                cl_collapse.visibility = View.GONE
                val scale = offset / (height / 2f)
                val alpha = (255 * scale).toInt()
                v_bg1.setBackgroundColor(Color.argb(alpha, 25, 131, 209))

            }
            offset <= height -> {
                cl_collapse.visibility = View.VISIBLE
                cl_normal.visibility = View.GONE
                val scale = (height - offset) / (height / 2f)
                val alpha = (255 * scale).toInt()
                v_bg2.setBackgroundColor(Color.argb(alpha, 25, 131, 209))
            }
            else -> v_bg2.setBackgroundColor(Color.argb(0, 25, 131, 209))
        }
//        val maxScrollRange = p0.totalScrollRange
//        val offset = abs(p1)
//        if (offset <= maxScrollRange / 2) {
//            cl_normal.visibility = View.VISIBLE
//            cl_collapse.visibility = View.GONE
//            val scale: Float = offset.toFloat() / (maxScrollRange / 2)
//            val alpha: Int = (255 * scale).toInt()
//            v_bg1.setBackgroundColor(Color.argb(alpha, 25, 131, 209))
//
//        } else {
//            cl_collapse.visibility = View.VISIBLE
//            cl_normal.visibility = View.GONE
//            val scale = (maxScrollRange - offset).toFloat() / (maxScrollRange / 2)
//            val alpha = (255 * scale).toInt()
//            v_bg2.setBackgroundColor(Color.argb(alpha, 25, 131, 209))
//        }
    }

    override fun onDestroy() {
        super.onDestroy()
        sv_refresh.cancelAnim()
        abl_zfb.removeOnOffsetChangedListener(this)
    }
}