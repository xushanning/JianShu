package com.xu.module.wan.ui.activity.search

import android.content.Context
import android.graphics.Rect
import android.util.DisplayMetrics
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.utlis.extention.observe
import com.xu.commonlib.utlis.extention.singleDbDataItemClick
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.base.BaseActivity
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WActivitySearchBinding
import com.xu.module.wan.ui.fragment.home.ArticlePagingAdapter
import com.xu.module.wan.viewmodel.HotKeyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.w_activity_search.*
import javax.inject.Inject

/**
 * 搜索
 */
@Route(path = ARouterPath.search)
@AndroidEntryPoint
class SearchActivity(override val layoutId: Int = R.layout.w_activity_search, override val variableId: Int = BR.vm) :
    BaseActivity<SearchViewModel, WActivitySearchBinding>() {

    @Inject
    lateinit var adapter: SearchHotKeyAdapter

    @Inject
    lateinit var pagingAdapter: ArticlePagingAdapter

    /**
     * 是否observer了pager
     */
    private var initPager = false


    /**
     * 热词
     */
    private val hotKeyViewModel: HotKeyViewModel by viewModels()

    override fun initView(mDataBinding: WActivitySearchBinding) {
        mDataBinding.click = OnClick()
        rv_hot_key.adapter = adapter
        rv_hot_key.layoutManager = GridLayoutManager(this, 2)
        adapter.singleDbDataItemClick {
            tv_search.setText(it.name)
            observeSearch()
        }


        rv_search.adapter = pagingAdapter
        rv_search.layoutManager = LinearLayoutManager(this)

        tv_search.isFocusable = true
        tv_search.isFocusableInTouchMode = true
        tv_search.requestFocus()
        tv_search.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                closeSearch()
                observeSearch()
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
    }

    private fun observeSearch() {
        if (!initPager) {
            observe(pagingAdapter, mViewModel.pager)
        } else {
            pagingAdapter.refresh()
        }
        initPager = true
        mViewModel.uiLiveData.postValue(false)
    }

    private fun closeSearch() {
        val manager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        manager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }

    override fun initData() {
        hotKeyViewModel.getHotKey()
        observe(hotKeyViewModel.hotKeyLiveData) {
            adapter.setNewInstance(it)
            if (it.size >= 1) {
                val position = (0 until it.size).random()
                mViewModel.searchHintLiveData.postValue(it[position].name)
            }
        }
    }

    override fun useLightMode(): Boolean {
        return true
    }

    /**
     * 键盘是否展示
     */
    private fun isShowSoft(): Boolean {
        val height = window.decorView.height
        val rect = Rect()
        window.decorView.getWindowVisibleDisplayFrame(rect)
        return (height * 2 / 3 - rect.bottom - getSoftButtonsBarHeight()) != 0
    }

    private fun getSoftButtonsBarHeight(): Int {
        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)
        val height = metrics.heightPixels
        windowManager.defaultDisplay.getRealMetrics(metrics)
        val realHeight = metrics.heightPixels
        return if (realHeight > height) {
            realHeight - height
        } else {
            0
        }
    }

    inner class OnClick {

        fun onCancel() {
            finish()
            //todo 判断软键盘状态没有适配好。。
//            if (isShowSoft()) {
//                closeSearch()
//            } else {
//
//            }
        }

        /**
         * 删除搜索记录
         */
        fun onDeleteClick() {

        }
    }
}