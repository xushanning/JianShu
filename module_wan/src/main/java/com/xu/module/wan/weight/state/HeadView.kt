package com.xu.module.wan.weight.state

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.xu.commonlib.utlis.extention.go
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.module.wan.R
import com.xu.module.wan.constant.ARouterPath
import kotlinx.android.synthetic.main.w_view_head.view.*

/**
 * head首页搜索view
 */
class HeadView : ConstraintLayout {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        initLayout()
    }

    private fun initLayout() {
        LayoutInflater.from(context).inflate(R.layout.w_view_head, this)
        v_1.singleClick {
            go(ARouterPath.search)
        }
    }
}