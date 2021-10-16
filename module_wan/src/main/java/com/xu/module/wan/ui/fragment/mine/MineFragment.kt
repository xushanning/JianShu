package com.xu.module.wan.ui.fragment.mine

import androidx.recyclerview.widget.GridLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.orhanobut.logger.Logger
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.xu.commonlib.utlis.AssetUtil
import com.xu.commonlib.utlis.extention.navigate
import com.xu.commonlib.utlis.extention.observe
import com.xu.commonlib.utlis.extention.showToast
import com.xu.commonlib.utlis.extention.singleDbDataItemClick
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.base.BaseFragment
import com.xu.module.wan.bean.CommonUseBean
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WFragmentMineBinding
import com.xu.module.wan.databinding.WItemCommonUseBinding
import com.xu.module.wan.db.dao.IUserDao
import com.xu.module.wan.ui.activity.integral.IntegralActivity
import com.xu.module.wan.utils.ext.createBindingAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.w_fragment_mine.*
import javax.inject.Inject

/**
 * 我的
 */
@Route(path = ARouterPath.mine)
@AndroidEntryPoint
class MineFragment(
    override val layoutId: Int = R.layout.w_fragment_mine,
    override val variableId: Int = BR.vm
) : BaseFragment<MineViewModel, WFragmentMineBinding>() {


    private var quickAdapter =
        createBindingAdapter<CommonUseBean, WItemCommonUseBinding>(R.layout.w_item_common_use) { holder, item ->
            holder.dataBinding?.item = item
        }

    @Inject
    lateinit var moShi: Moshi

    @Inject
    lateinit var userDao: IUserDao


//    val launcher = forResult {
//        Logger.d("登陆成功了")
//    }

    override fun initView(mDataBinding: WFragmentMineBinding) {
        mDataBinding.click = OnClick()
        rv_common_use.run {
            layoutManager = GridLayoutManager(context, 4)
            adapter = quickAdapter
        }


        quickAdapter.run {
            setNewInstance(getConfig())
            singleDbDataItemClick {
                navigate(it.path) { withInt("type", it.type) }
            }
        }
    }

    override fun initData() {
        observe(mViewModel.loginStatus) {
            if (it) {
                mViewModel.changeUi()
                mViewModel.getRank()
            }
        }
        observe(mViewModel.userInfoLiveData) {
            Logger.d(it.username)
        }

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
            navigate(ARouterPath.login)
            // launcher.launch(Intent(context, LoginActivity::class.java))
        }

        /**
         * 个人主页
         */
        fun jumpPersonPage() {
            showToast("假的。。别点了")
        }

        /**
         * 积分排行
         */
        fun jumpIntegral() {
            navigate(ARouterPath.integral) {
                withInt("type", IntegralActivity.INTEGRAL_TYPE_RANK)
            }
        }
    }
}