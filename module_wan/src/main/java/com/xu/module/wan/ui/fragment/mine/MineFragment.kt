package com.xu.module.wan.ui.fragment.mine

import android.app.Activity
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.orhanobut.logger.Logger
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.xu.commonlib.base.mvvm.BaseVmFragment
import com.xu.commonlib.utlis.AssetUtil
import com.xu.commonlib.utlis.extention.forResult
import com.xu.commonlib.utlis.extention.go
import com.xu.commonlib.utlis.extention.singleDbDataItemClick
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.bean.CommonUseBean
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WFragmentMineBinding
import com.xu.module.wan.ui.activity.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.w_fragment_mine.*
import javax.inject.Inject

/**
 * 我的
 */
@Route(path = ARouterPath.mine)
@AndroidEntryPoint
class MineFragment(override val layoutId: Int = R.layout.w_fragment_mine, override val variableId: Int = BR.vm) :
    BaseVmFragment<MineViewModel, WFragmentMineBinding>() {

    private val quickAdapter: CommonUseAdapter by lazy { CommonUseAdapter() }

    @Inject
    lateinit var moShi: Moshi


    val launcher = forResult {
        Logger.d("登陆成功了")
    }

    override fun initView(mDataBinding: WFragmentMineBinding) {
        mDataBinding.click = OnClick()
        rv_common_use.run {
            layoutManager = GridLayoutManager(context, 4)
            adapter = quickAdapter
        }


        quickAdapter.run {
            setNewInstance(getConfig())
            singleDbDataItemClick {

            }
        }
    }

    override fun initData() {

    }

    private fun getConfig(): MutableList<CommonUseBean> {
        val config = AssetUtil.getAssetJson("mineConfig.json")
        val type = Types.newParameterizedType(MutableList::class.java, CommonUseBean::class.java)
        val jsonAdapter = moShi.adapter<MutableList<CommonUseBean>>(type)
        return jsonAdapter.fromJson(config)!!
    }


    inner class OnClick {
        /**
         * 去登陆
         */
        fun jumpLogin() {
            launcher.launch(Intent(context, LoginActivity::class.java))
        }
    }
}