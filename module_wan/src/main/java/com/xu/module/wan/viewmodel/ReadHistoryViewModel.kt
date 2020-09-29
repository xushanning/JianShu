package com.xu.module.wan.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.mvvm.BaseViewModel
import com.xu.module.wan.bean.ArticleItemBean
import com.xu.module.wan.db.WanSp
import com.xu.module.wan.db.dao.IReadHistoryDao
import com.xu.module.wan.db.entity.ReadHistoryEntity
import kotlinx.coroutines.launch

/**
 * 阅读历史
 */
class ReadHistoryViewModel @ViewModelInject constructor(
    private val dao: IReadHistoryDao
) : BaseViewModel() {
    /**
     * 阅读历史LiveData
     */
    val readHistoryLiveData = dao.queryReadHistoryById(WanSp.currentUserId)

    /**
     * 保存新的阅读历史
     */
    fun saveHistory(newRead: ArticleItemBean) {
        viewModelScope.launch {
            val history = dao.queryReadHistory(WanSp.currentUserId)
            if (history == null) {
                Logger.d("一直为null")
                val list = arrayListOf(newRead)
                val entity = ReadHistoryEntity(0, WanSp.currentUserId, list)
                dao.saveHistory(entity)
            } else {
                val historyList = history.articles
                val size = historyList.size
                var position = -1
                //确定位置
                run breaking@{
                    historyList.forEachIndexed { index, oldRead ->
                        if (oldRead.id == newRead.id) {
                            position = index
                            return@breaking
                        }
                    }
                }
                if (position == -1) {
                    if (size >= 99) {
                        historyList.removeAt(size - 1)
                    }
                } else {
                    historyList.removeAt(position)
                }
                historyList.add(0, newRead)
                dao.updateHistory(history)
            }
        }
    }

}