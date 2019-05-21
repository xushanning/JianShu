package com.xu.commonlib.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.orhanobut.logger.Logger
import com.xu.commonlib.R
import kotlinx.android.synthetic.main.r_view_toolbar.view.*

/**
 * @author 言吾許
 * 自定义toolbar
 */
class CustomToolbar : Toolbar {

    /**
     * 是否显示回退健
     */
    private var showBack = true


    private var titleId = 0

    constructor(context: Context) : super(context) {
        initView(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView(attrs, defStyleAttr)
    }

    private fun initView(attrs: AttributeSet?, defStyleAttr: Int) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomToolbar, defStyleAttr, 0)
        showBack = typedArray.getBoolean(R.styleable.CustomToolbar_showBack, true)
        titleId = typedArray.getResourceId(R.styleable.CustomToolbar_barTitle, 0)
        typedArray.recycle()
        LayoutInflater.from(context).inflate(R.layout.r_view_toolbar, this, true)
        //必写，否则会出ui问题
        setContentInsetsRelative(0, 0)

        if (titleId != 0) {
            tv_title.text = context.getString(titleId)
        }

        if (!showBack) {
            iv_back.visibility = View.GONE
        }
    }

    /**
     * 设置title
     */
    fun setBarTitle(title: String) {
        tv_title.text = title
    }

    fun setOnBackClickListener(onBackClickListener: OnClickListener) {
        iv_back.setOnClickListener(onBackClickListener)
    }
}