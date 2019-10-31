package com.xu.module.video.ui.fragment.completed

import com.xu.commonlib.db.dao.IVideoDao
import com.xu.commonlib.mvp.BaseModel
import javax.inject.Inject

/**
 * @author 言吾許
 */
class CompletedModel @Inject constructor() : BaseModel(), ICompletedContract.ICompletedModel {
    @Inject
    lateinit var dao: IVideoDao
}