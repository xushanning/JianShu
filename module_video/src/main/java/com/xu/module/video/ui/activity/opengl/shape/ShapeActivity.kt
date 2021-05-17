package com.xu.module.video.ui.activity.opengl.shape

import android.Manifest
import android.os.Bundle
import com.google.android.flexbox.FlexboxLayoutManager
import com.orhanobut.logger.Logger
import com.permissionx.guolindev.PermissionX
import com.xu.commonlib.base.BaseActivity
import com.xu.commonlib.utlis.extention.createAdapter
import com.xu.commonlib.utlis.extention.permission
import com.xu.commonlib.utlis.extention.singleDataItemClick
import com.xu.module.video.R
import com.xu.module.video.bean.ShapeBean
import kotlinx.android.synthetic.main.v_activity_open_gl_shape.*

/**
 * @author 许
 * open GL 绘制形状
 */
class ShapeActivity : BaseActivity() {

    private val shapeAdapter =
        createAdapter<ShapeBean>(R.layout.v_item_open_gl_shape) { holder, item ->
            holder.setText(R.id.bt_shape, item.name)
        }

    override fun setLayoutId(): Int {
        return R.layout.v_activity_open_gl_shape
    }

    override fun initView(savedInstanceState: Bundle?) {
        rv_shape.run {
            adapter = shapeAdapter
            layoutManager = FlexboxLayoutManager(this@ShapeActivity)
            shapeAdapter.singleDataItemClick(10) {
                //重新刷新，onPause和onResume后，会重新走onSurfaceCreated，这样在一个页面就能重新刷新了
                sv_shape.onPause()
                sv_shape.onResume()
                sv_shape.refresh(it.id)
            }
        }
        permission(
            Manifest.permission.CAMERA
        ) { allGranted ->
            if (allGranted) {
                Logger.d("权限全过了")
            } else {
                Logger.d("给个权限吧。。")
            }
        }
    }

    override fun initData() {
        val list = ArrayList<ShapeBean>()
        list.add(ShapeBean(1, "三角形"))
        list.add(ShapeBean(2, "正三角形"))
        list.add(ShapeBean(3, "彩色三角形"))
        list.add(ShapeBean(4, "正方形"))
        list.add(ShapeBean(5, "圆形"))
        list.add(ShapeBean(6, "正方体"))
        list.add(ShapeBean(7, "圆锥"))
        list.add(ShapeBean(8, "圆柱"))
        list.add(ShapeBean(9, "球体"))
        list.add(ShapeBean(10, "带光源的球体"))
        list.add(ShapeBean(11, "Bitmap"))
        shapeAdapter.setNewInstance(list)
    }

}