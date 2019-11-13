package com.xu.module.jianshu.ui.hook

import android.os.Bundle
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.xu.commonlib.base.BaseActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.module.jianshu.R
import kotlinx.android.synthetic.main.j_activity_hook.*

/**
 * @author 言吾許
 * 测试hook代码
 */
@Route(path = ARouterPath.jianshuHook)
class HookActivity : BaseActivity() {
    override fun setLayoutId(): Int {
        return R.layout.j_activity_hook
    }

    override fun initView(savedInstanceState: Bundle?) {
        bt_hook.singleClick {
            Toast.makeText(this, "我被点击了。。.", Toast.LENGTH_SHORT).show()
        }
        ViewClickHookHelper.hook(this, bt_hook)
    }

    override fun initData() {

    }
}