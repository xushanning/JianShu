package com.xu.module.sport.ui.fragment.home

import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.helper.widget.Layer
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.zhouwei.library.CustomPopWindow
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.BaseMvpFragment
import com.xu.commonlib.constant.ARouterPath
import com.xu.commonlib.db.dao.ISportDao
import com.xu.commonlib.db.entity.PointBean
import com.xu.commonlib.db.entity.TrajectoryEntity
import com.xu.commonlib.utlis.AssetUtil
import com.xu.commonlib.utlis.TransformUtil
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.module.sport.R
import kotlinx.android.synthetic.main.s_fragment_home.*
import java.util.*
import javax.inject.Inject

/**
 * @author 言吾許
 */
@Route(path = ARouterPath.sportHome)
class HomeFragment : BaseMvpFragment<IHomeContract.IHomeView, IHomeContract.IHomePresenter>(),
    IHomeContract.IHomeView {
    @Inject
    lateinit var sportDao: ISportDao

    private var sportTypePop: CustomPopWindow? = null

    override fun setLayoutId(): Int {
        return R.layout.s_fragment_home
    }

    override fun initView(view: View) {
        s_button.singleClick {
            ARouter.getInstance()
                .build(ARouterPath.sportHistoryList)
                .navigation()
        }
        bt_inject.singleClick {
            sportDao.saveSportTrajectory(generateData())
                .compose(TransformUtil.defaultCompletableSchedulers())
                .subscribe({
                    Logger.d("写入完毕")
                }, { Logger.d(it.message) })
        }
        img_home_message.singleClick {
            showToast("消息..正在开发")
        }
        img_home_friend.singleClick {
            showToast("好友..正在开发")
        }
        img_home_notification.singleClick {
            showToast("通知..正在开发")
        }
        img_home_setting.singleClick {
            showToast("设置..正在开发")
        }
        v_bind_phone.singleClick {
            showToast("别听他的，不用绑定手机号")
        }

        //月份
        tv_month.text =
            getString(R.string.s_home_filter_month, Calendar.getInstance().get(Calendar.MONTH) + 1)
        initSportType()

    }

    /**
     * 初始化运动类型
     */
    private fun initSportType() {
        val sportTypeView =
            LayoutInflater.from(context).inflate(R.layout.s_view_sport_type_select, null)
        setSportTypeColor(sportTypeView, R.color.res_black, R.color.res_66, R.color.res_66)
        sportTypeView.findViewById<Layer>(R.id.l_bike).singleClick {
            refreshSportData()
        }
        sportTypeView.findViewById<Layer>(R.id.l_run).singleClick {
            refreshSportData()
        }
        sportTypeView.findViewById<Layer>(R.id.l_foot).singleClick {
            refreshSportData()
        }



        tv_sport_type.singleClick {
            sportTypePop = CustomPopWindow.PopupWindowBuilder(context)
                .setView(sportTypeView)
                .enableBackgroundDark(true)
                .setBgDarkAlpha(1f)
                .create()
                .showAsDropDown(tv_sport_type, 0, 20)
        }
    }

    private fun setSportTypeColor(parentView: View, bikeColor: Int, runColor: Int, footColor: Int) {
        parentView.findViewById<ImageView>(R.id.img_bike).drawable.setTint(bikeColor)
        parentView.findViewById<ImageView>(R.id.img_run).drawable.setTint(runColor)
        parentView.findViewById<ImageView>(R.id.img_foot).drawable.setTint(footColor)

        parentView.findViewById<TextView>(R.id.tv_bike).setTextColor(bikeColor)
        parentView.findViewById<TextView>(R.id.tv_run).setTextColor(runColor)
        parentView.findViewById<TextView>(R.id.tv_foot).setTextColor(footColor)

    }


    /**
     * 刷新首页的运动数据
     */
    private fun refreshSportData() {
        sportTypePop?.dissmiss()


    }

    private fun generateData(): TrajectoryEntity {
        val entity = TrajectoryEntity()
        entity.heat = random(2, 100)
        entity.trajectoryId = generateTrajectoryId()
        entity.sportTime = random(1, 3600).toLong()
        entity.totalTime = random(100, 100000).toLong()
        entity.sportMileage = random(1000, 100000).toFloat()
        entity.complete = true
        entity.startTime = 1566465010329
        entity.lastInsertTime = 1566466010329
        entity.year = random(2015, 2019)
        entity.month = random(1, 12)
        entity.day = random(1, 30)
        entity.trajectoryPoints = generatePoint()

        return entity
    }

    private fun generatePoint(): List<PointBean> {
        val json = AssetUtil.getAssetJson("location.json")
        return Gson().fromJson(json, object : TypeToken<List<PointBean>>() {}.type)
    }

    private fun random(min: Int, max: Int): Int {
        return Random().nextInt(max - min + 1) + min
    }

    private fun generateTrajectoryId(): String {
        val s = UUID.randomUUID().toString()
        return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(
            19,
            23
        ) + s.substring(24)
    }
}