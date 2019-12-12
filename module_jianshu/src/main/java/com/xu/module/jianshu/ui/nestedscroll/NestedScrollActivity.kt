package com.xu.module.jianshu.ui.nestedscroll

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.xu.commonlib.base.BaseActivity
import com.xu.module.jianshu.R
import com.xu.module.jianshu.ui.coordinatorlayout.CoordinatorAdapter
import kotlinx.android.synthetic.main.j_activity_nested_scroll.*


/**
 * https://www.jianshu.com/p/8be7458c644b
 */
class NestedScrollActivity : BaseActivity() {
    override fun setLayoutId(): Int {
        return R.layout.j_activity_nested_scroll
    }

    override fun initView(savedInstanceState: Bundle?) {
        val data = arrayOf("Sunny", "Cloudy", "Few Clouds", "Partly Cloudy", "Overcast", "Windy", "Calm", "Light Breeze",
                "Moderate", "Fresh Breeze", "Strong Breeze", "High Wind", "Gale", "Strong Gale", "Storm", "Violent Storm", "Hurricane",
                "Tornado", "Tropical Storm", "Shower Rain", "Heavy Shower Rain", "Thundershower", "Heavy Thunderstorm", "Thundershower with hail",
                "Light Rain", "Moderate Rain", "Heavy Rain", "Extreme Rain", "Drizzle Rain", "Storm", "Heavy Storm", "Severe Storm", "Freezing Rain",
                "Light to moderate rain", "Moderate to heavy rain", "Heavy rain to storm", "Storm to heavy storm", "Heavy to severe storm",
                "Rain", "Light Snow", "Moderate Snow", "Heavy Snow", "Snowstorm", "Sleet", "Rain And Snow", "Shower Snow", "Snow Flurry",
                "Light to moderate snow", "Moderate to heavy snow", "Heavy snow to snowstorm", "Snow", "Mist", "Foggy", "Haze", "Sand", "Dust",
                "Duststorm", "Sandstorm", "Dense fog", "Strong fog", "Moderate haze", "Heavy haze", "Severe haze", "Heavy fog", "Extra heavy fog",
                "Hot", "Cold", "Unknown")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        list.adapter = adapter

//        val quickAdapter = CoordinatorAdapter(ArrayList())
//        rv_nested.adapter = quickAdapter
//        rv_nested.layoutManager = LinearLayoutManager(this)
//        val rvData = ArrayList<String>()
//        for (i in 1..100) {
//            rvData.add(i.toString())
//        }
//        quickAdapter.setNewData(rvData)
    }

    override fun initData() {
    }
}