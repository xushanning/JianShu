package com.xu.module.wan.ui.activity.search

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.commonlib.livedata.BooleanLiveData
import com.xu.commonlib.livedata.StringLiveData
import com.xu.module.wan.api.WanService
import com.xu.module.wan.db.WanSp
import com.xu.module.wan.db.dao.ISearchHistoryDao
import com.xu.module.wan.db.entity.SearchHistoryEntity
import com.xu.module.wan.utils.ext.createPager
import kotlinx.coroutines.launch

class SearchViewModel @ViewModelInject constructor(
    private val api: WanService,
    private val dao: ISearchHistoryDao
) : BaseViewModel() {


    /**
     *默认搜索
     */
    val searchHintLiveData = StringLiveData()

    /**
     * 显示
     * true:显示热词和搜索历史
     * false:显示搜索历史
     */
    val uiLiveData = BooleanLiveData(true)

    /**
     * 搜索内容
     */
    val searchLiveData = StringLiveData()

    /**
     * 搜索历史
     */
    val searchHistoryLiveData = dao.querySearchHistoryLiveData(WanSp.currentUserId)

    /**
     * 搜索分页
     */
    var pager = createPager {
        api.doSearch(it, getSearchContent())
    }

    /**
     * 保存历史记录
     */
    fun saveHistory() {
        viewModelScope.launch {
            val history = searchHistoryLiveData.value
            val content = getSearchContent()
            if (history == null) {
                //空，新增一条
                val list = arrayListOf(content)
                val entity = SearchHistoryEntity(WanSp.currentUserId, list)
                dao.saveHistory(entity)
            } else {
                //更新
                val list = history.history
                val size = list.size
                val position = list.indexOf(content)
                if (position == -1) {
                    //不存在，没有搜索过，如果长度超过了9，那么移除超出的部分
                    if (size >= 9) {
                        list.removeAt(size - 1)
                    }
                } else {
                    //存在，那么移动到最前面
                    list.removeAt(position)
                }
                list.add(0, content)
                dao.updateHistory(history)
            }
        }
    }

    /**
     * 删除当前用户下的搜索记录
     */
    fun deleteHistory() {
        viewModelScope.launch {
            val history = searchHistoryLiveData.value
            if (history != null) {
                val list = history.history
                list.clear()
                dao.updateHistory(history)
            }
        }
    }

    /**
     * 获取搜索的内容
     */
    private fun getSearchContent(): String {
        return if (searchLiveData.value.isEmpty()) {
            //如果没有输入，那么搜索默认的hilt
            searchHintLiveData.value
        } else {
            searchLiveData.value
        }
    }

}