package com.xu.commonlib.mvp

import com.xu.commonlib.db.dao.ISportDao
import javax.inject.Inject

/**
 * @author 言吾許
 */
abstract class BaseModel : IModel {

    @Inject
    lateinit var sportDao: ISportDao

    override fun onDetach() {

    }
}