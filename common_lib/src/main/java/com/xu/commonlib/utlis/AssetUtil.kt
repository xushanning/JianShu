package com.xu.commonlib.utlis

import com.xu.commonlib.base.BaseApplication
import java.util.*

/**
 * @author 言吾許
 */
object AssetUtil {
    /**
     * 获取asset下的json数据
     */
    fun getAssetJson(fileName: String): String {
        val input = BaseApplication.appContext.assets.open(fileName)
        var json = ""
        val scanner = Scanner(input, "UTF-8").useDelimiter("\\A")
        if (scanner.hasNext()) {
            json = scanner.next()
        }
        input.close()
        return json
    }

}