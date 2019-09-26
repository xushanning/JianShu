package com.xu.module.sport.ui.fragment.home

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.helper.widget.Layer
import androidx.core.content.ContextCompat
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
import com.xu.module.sport.constant.SportTypeConstant
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
    /**
     * 首页查询的运动类型
     */
    private var querySportType = SportTypeConstant.SPORT_TYPE_BIKE


    override fun setLayoutId(): Int {
        return R.layout.s_fragment_home
    }

    override fun initView(view: View) {
        val font1 = Typeface.createFromAsset(context!!.assets, "fonts/font1.otf")
        tv_sport_time.typeface = font1
        tv_rank.typeface = font1
        tv_mileage.typeface = font1

        tv_sport_history.singleClick {
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

        img_question.singleClick {
            showToast("疑问..正在开发")
        }
        tv_my_medal.singleClick {
            showToast("我的勋章..正在开发")
        }

        tv_total_mileage.text = getString(R.string.s_home_sport_total_mileage, 0.0f)

        //本月运动热度
        tv_month_heat.text = getString(R.string.s_home_sport_heat, 0)

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
        sportTypeView.findViewById<Layer>(R.id.l_bike).singleClick {
            querySportType = SportTypeConstant.SPORT_TYPE_BIKE

            refreshSportData(R.string.s_home_sport_type_bike, R.mipmap.s_sport_type_bike_focus)
        }
        sportTypeView.findViewById<Layer>(R.id.l_run).singleClick {
            querySportType = SportTypeConstant.SPORT_TYPE_RUN
            tv_sport_type.text = getString(R.string.s_home_sport_type_run)
            refreshSportData(R.string.s_home_sport_type_run, R.mipmap.s_sport_type_run_focus)
        }
        sportTypeView.findViewById<Layer>(R.id.l_foot).singleClick {
            querySportType = SportTypeConstant.SPORT_TYPE_FOOT
            tv_sport_type.text = getString(R.string.s_home_sport_type_foot)
            refreshSportData(R.string.s_home_sport_type_foot, R.mipmap.s_sport_type_foot_focus)
        }


        tv_sport_type.text = getString(R.string.s_home_sport_type_bike)
        tv_sport_type.singleClick {
            sportTypePop = CustomPopWindow.PopupWindowBuilder(context)
                .setView(sportTypeView)
                .enableBackgroundDark(true)
                .setBgDarkAlpha(1f)
                .create()
                .showAsDropDown(tv_sport_type, 0, 20)
            refreshUi(sportTypeView)
        }
        refreshSportData(R.string.s_home_sport_type_bike, R.mipmap.s_sport_type_bike_focus)
    }

    override fun loadCurrentMonthSportStatistics(
        sportMileage: String,
        sportRank: String,
        sportTime: String
    ) {

    }

    /**
     * 刷新弹窗UI
     */
    private fun refreshUi(sportTypeView: View) {
        when (querySportType) {
            SportTypeConstant.SPORT_TYPE_BIKE -> {
                setSportTypeImg(
                    sportTypeView,
                    R.mipmap.s_sport_type_bike_focus,
                    R.mipmap.s_sport_type_run_unfocus,
                    R.mipmap.s_sport_type_foot_unfocus,
                    R.color.res_black,
                    R.color.res_99,
                    R.color.res_99
                )
            }
            SportTypeConstant.SPORT_TYPE_RUN -> {
                setSportTypeImg(
                    sportTypeView,
                    R.mipmap.s_sport_type_bike_unfocus,
                    R.mipmap.s_sport_type_run_focus,
                    R.mipmap.s_sport_type_foot_unfocus,
                    R.color.res_99,
                    R.color.res_black,
                    R.color.res_99
                )
            }
            SportTypeConstant.SPORT_TYPE_FOOT -> {
                setSportTypeImg(
                    sportTypeView,
                    R.mipmap.s_sport_type_bike_unfocus,
                    R.mipmap.s_sport_type_run_unfocus,
                    R.mipmap.s_sport_type_foot_focus,
                    R.color.res_99,
                    R.color.res_99,
                    R.color.res_black
                )
            }
        }
    }

    /**
     * 设置弹窗的img和字体颜色
     */
    private fun setSportTypeImg(
        parentView: View,
        bikeImg: Int,
        runImg: Int,
        footImg: Int,
        bikeColor: Int,
        runColor: Int,
        footColor: Int
    ) {
        parentView.findViewById<ImageView>(R.id.img_bike).setImageResource(bikeImg)
        parentView.findViewById<ImageView>(R.id.img_run).setImageResource(runImg)
        parentView.findViewById<ImageView>(R.id.img_foot).setImageResource(footImg)

        parentView.findViewById<TextView>(R.id.tv_bike)
            .setTextColor(ContextCompat.getColor(context!!, bikeColor))
        parentView.findViewById<TextView>(R.id.tv_run)
            .setTextColor(ContextCompat.getColor(context!!, runColor))
        parentView.findViewById<TextView>(R.id.tv_foot)
            .setTextColor(ContextCompat.getColor(context!!, footColor))
    }


    /**
     * 刷新首页的运动数据
     */
    private fun refreshSportData(tvType: Int, imgType: Int) {
        sportTypePop?.dissmiss()
        tv_sport_type.text = getString(tvType)
        img_sport_type.setImageResource(imgType)
        mPresenter.getCurrentMonthSportStatistics(querySportType)

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
        entity.sportType = random(1, 3)

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