package com.xu.commonlib.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.trello.rxlifecycle3.components.support.RxFragment
import com.xu.commonlib.mvp.IBaseView

/**
 * @author 言吾許
 */
abstract class BaseFragment : RxFragment(), IBaseView {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(setLayoutId(), container, false)
        initMvp()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        initData()
    }

    /**
     * 设置布局
     */
    abstract fun setLayoutId(): Int

    /**
     * 初始化view相关
     */
    abstract fun initView(view: View)

    /**
     * 初始化数据
     */
    abstract fun initData()

    open fun initMvp() {

    }

    override fun showDialog(content: String) {

    }

    override fun showDialog() {
    }

    override fun dismissDialog() {
    }

    override fun showToast(content: String) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show()
    }


}