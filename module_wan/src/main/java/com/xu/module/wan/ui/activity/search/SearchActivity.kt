package com.xu.module.wan.ui.activity.search

import android.content.Context
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.orhanobut.logger.Logger
import com.xu.commonlib.utlis.extention.observe
import com.xu.commonlib.utlis.extention.singleDataItemClick
import com.xu.commonlib.utlis.extention.singleDbDataItemClick
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.base.BaseActivity
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WActivitySearchBinding
import com.xu.module.wan.ui.fragment.home.ArticlePagingAdapter
import com.xu.module.wan.utils.ext.createAdapter
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
     * 搜索历史adapter
     */
    private val historyAdapter =
        createAdapter<String>(R.layout.w_item_hot_key_history) { holder, item ->
            holder.setText(R.id.tv_content, item)
        }

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
            et_search.setText(it.name)
            observeSearch()
        }


        rv_search.adapter = pagingAdapter
        rv_search.layoutManager = LinearLayoutManager(this)


        rv_search_history.adapter = historyAdapter
        rv_search_history.layoutManager = GridLayoutManager(this, 2)
        historyAdapter.singleDataItemClick {
            et_search.setText(it)
            observeSearch()
        }

        et_search.isFocusable = true
        et_search.isFocusableInTouchMode = true
        et_search.requestFocus()
        et_search.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                observeSearch()
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }


    }

    private fun observeSearch() {
        closeSearch()
        if (!initPager) {
            observe(pagingAdapter, mViewModel.pager)
        } else {
            pagingAdapter.refresh()
        }
        initPager = true
        mViewModel.uiLiveData.postValue(false)
        mViewModel.saveHistory()
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
        observe(mViewModel.searchHistoryLiveData) {
            historyAdapter.setNewInstance(it?.history)
        }
    }

    override fun useLightMode(): Boolean {
        return true
    }

    /**
     * 软键盘可见性
     */
    private fun getKeyboardVisible(): Boolean {
        val imm by lazy { getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager }
        val windowHeightMethod =
            InputMethodManager::class.java.getMethod("getInputMethodWindowVisibleHeight")
        try {
            return windowHeightMethod.invoke(imm) as Int > 0
        } catch (e: Exception) {
            Logger.d(e.message)
        }
        return false
    }


    inner class OnClick {

        fun onCancel() {
            //逻辑：如果用户没有输入内容，那么直接关闭页面，如果主动输入了搜索内容，那么判断
            //软键盘是否打开，如果打开了，那么关闭软键盘，否则finish
            if (mViewModel.searchLiveData.value.isEmpty()) {
                finish()
            } else {
                if (getKeyboardVisible()) {
                    closeSearch()
                } else {
                    finish()
                }
            }

        }

        /**
         * 删除搜索记录
         */
        fun onDeleteClick() {
            mViewModel.deleteHistory()
        }
    }
}