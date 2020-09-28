package com.xu.module.wan.ui.fragment.navigation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.flexbox.FlexboxLayoutManager
import com.orhanobut.logger.Logger
import com.xu.commonlib.utlis.extention.observe
import com.xu.commonlib.utlis.extention.singleItemClick
import com.xu.commonres.sticky.OnStickyChangeListener
import com.xu.commonres.sticky.StickyItemDecoration
import com.xu.module.wan.BR
import com.xu.module.wan.R
import com.xu.module.wan.base.BaseFragment
import com.xu.module.wan.bean.NavigationBean
import com.xu.module.wan.constant.ARouterPath
import com.xu.module.wan.databinding.WFragmentNavigationBinding
import com.xu.module.wan.utils.ext.createAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.w_fragment_navigation.*
import kotlinx.android.synthetic.main.w_item_navigation_right_head.*
import me.jingbin.library.stickyview.StickyGridLayoutManager
import javax.inject.Inject

/**
 * @author 许 on 2020/9/21.
 * 导航栏
 */
@Route(path = ARouterPath.stationNavigation)
@AndroidEntryPoint
class NavigationFragment(override val layoutId: Int = R.layout.w_fragment_navigation, override val variableId: Int = BR.vm) :
    BaseFragment<NavigationViewModel, WFragmentNavigationBinding>() {
    @Inject
    lateinit var rightAdapter: NavigationAdapter

    private lateinit var gridLayoutManager:StickyGridLayoutManager
    private val leftAdapter =
        createAdapter<NavigationBean>(R.layout.w_item_navigation_left) { holder, item ->
            holder.setText(R.id.tv_sort_name, item.name)
        }


    override fun initView(mDataBinding: WFragmentNavigationBinding) {

        rv_left.run {
            adapter = leftAdapter
        }
        leftAdapter.singleItemClick {
            Logger.d(it)
        }
        gridLayoutManager = StickyGridLayoutManager(
            requireContext(),
            2,
            GridLayoutManager.VERTICAL,
            rightAdapter
        )
        rv_right.run {
            layoutManager = gridLayoutManager
            adapter = rightAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val position = gridLayoutManager.findFirstVisibleItemPosition()
                    Logger.d(position)
                }
            })
        }


    }

    override fun initData() {
        mViewModel.getNavigationData()
        observe(mViewModel.navigationLiveData) {
            leftAdapter.setNewInstance(it)
        }
        observe(mViewModel.rightLiveData) {
            rightAdapter.setNewData(it)
        }
    }

    private fun moveToCenter(position: Int) {
        val manager = rv_left.layoutManager as LinearLayoutManager
        val child = rv_left.getChildAt(position - manager.findFirstVisibleItemPosition())
        if (child != null) {
            val y = (child.top - rv_left.height) / 2
            rv_left.smoothScrollBy(0, y)
        }
    }
}