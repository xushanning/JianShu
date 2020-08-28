package com.xu.module.jianshu.ui.coroutine

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.alibaba.android.arouter.facade.annotation.Route
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.BaseMvpActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.commonlib.utlis.extention.singleClick
import com.xu.module.jianshu.R
import kotlinx.android.synthetic.main.j_activity_coroutine.*
import kotlinx.coroutines.*

@Route(path = ARouterPath.jianshuCoroutine)
class CoroutineActivity :
    BaseMvpActivity<ICoroutineContract.ICoroutineView, ICoroutineContract.ICoroutinePresenter>(),
    ICoroutineContract.ICoroutineView {


    override fun setLayoutId() = R.layout.j_activity_coroutine


    override fun initView(savedInstanceState: Bundle?) {
        bt_coroutine_start.singleClick {
            start3()
        }

    }

    override fun initData() {
        mPresenter.getData()
    }

    override fun loadData(name: String) {
        tv_name.text = name
    }


    suspend fun start() {
        withContext(Dispatchers.IO) {
            Logger.d(Thread.currentThread().name)
        }
    }

    fun start1() {
        //启动的协程任务会阻断当前线程
        runBlocking {

            //重复8次
            repeat(8) {
                //延时1s
                delay(1000)
            }
        }
    }

    suspend fun start2() {
        //返回一个job类型的对象，这种方式不会阻断主线程
        val job: Job = lifecycleScope.launch(Dispatchers.IO) {
            delay(1000)
        }
        job.isActive
        job.isCompleted
        job.isCancelled
        job.cancel()
        job.join()

    }

    private fun start3() {
        //必须外面套一层
        lifecycleScope.launch {
            val result0 = getResult()
            //async可以支持并发，此时一般都跟await一起使用,这样会阻塞外面的协程
            val result1 = async {
                getResult1(result0)
            }.await()
            //async返回Deferred<T>
            val result2 = async {
                getResult2(result0)
            }.await()
            //Deferred<T>.await() 返回T，这里也就是String类型
            val result = "$result1=========$result2"
            Logger.d(result)
        }
    }

    private suspend fun getResult(): String {
        Logger.d("开始获取参数")
        delay(2000)
        return "返回后面需要的参数"
    }


    private suspend fun getResult1(params: String): String {
        Logger.d(Thread.currentThread().name)
        delay(1000)
        Logger.d("返回result1")
        return "result1"
    }

    private suspend fun getResult2(params: String): String {
        Logger.d(Thread.currentThread().name)
        delay(5000)
        Logger.d("返回result2")
        return "result2"
    }

    override fun onDestroy() {
        super.onDestroy()
        // cancel()
    }
}