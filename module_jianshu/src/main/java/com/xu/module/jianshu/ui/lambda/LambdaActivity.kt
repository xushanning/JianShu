package com.xu.module.jianshu.ui.lambda

import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.orhanobut.logger.Logger
import com.xu.commonlib.base.BaseActivity
import com.xu.commonlib.constant.ARouterPath
import com.xu.module.jianshu.R
import com.xu.module.jianshu.ui.lambda.dsl.create
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.functions.Function
import kotlinx.android.synthetic.main.j_activity_lambda.*

@Route(path = ARouterPath.jianshuLambda)
class LambdaActivity : BaseActivity() {

    private var javaListener: JavaInterface? = null
    private var kotlinListener: KotlinInterface? = null


    override fun setLayoutId(): Int {
        return R.layout.j_activity_lambda
    }

    override fun initView(savedInstanceState: Bundle?) {
        //两个是一样的
        //val sum  = { i: Int, j: Int -> i + j }
        val sum: (Int, Int) -> Int = { i, j -> i + j }
        /**
         * 因此lambda定义就是
         * 方法名:(参数类型1,参数类型2,。。。)->返回值类型={参数1,参数2,。。。->具体实现方法}
         */
        Logger.d(sum(1, 2))
        //这样也是可以的
        Logger.d({ i: Int, j: Int -> i + j }(1, 2))
        //用run函数
        Logger.d(run { { i: Int, j: Int -> i + j }(1, 2) })

        /**
         * 原始的写法
         */
        bt_lambda.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Logger.d("按钮被点击了")
            }

        })
        /**
         * 可以看到setOnClickListener方法传入了一个 匿名内部类
         * kotlin规定，如果对象是单个Java(必须是java！！！如果类似 test2方法的kotlin接口，不行！！！)抽象方法的接口，那么可以用带有
         * 接口类型的前缀(这里是View.OnClickListener)的lambda表达式来表示
         * OnClickListener接口，参数为View，因此可以变成如下写法
         */
        bt_lambda.setOnClickListener(View.OnClickListener { v: View ->
            Logger.d("按钮被点击了")
            Logger.d(v.id)
        })
        /**
         *因为setOnClickListener 是java代码 View中的方法，所以接口类型的前缀可以省略
         * 变成下面这样，test2方法中可以看到set方法在kotlin和java中的区别
         */
        bt_lambda.setOnClickListener({ v: View ->
            Logger.d("按钮被点击了")
            Logger.d(v.id)
        })

        /**
         * kotlin语法约定，如果lambda表达式是函数是最后一个实参的话，它可以放在
         * 括号外面
         * @see com.xu.module.jianshu.ui.retrofit.Retrofit.create 参考这个方法动态代理的kotlin写法
         */
        bt_lambda.setOnClickListener() { v: View ->
            Logger.d("按钮被点击了")
            Logger.d(v.id)
        }

        /**
         * kotlin规定，如果lambda是函数的唯一实参的时候
         * 小括号可以直接省略，因此变成这样
         */
        bt_lambda.setOnClickListener { v: View ->
            Logger.d("按钮被点击了")
            Logger.d(v.id)
        }
        /**
         * 因为kotlin中可以推导出参数的类型，因此可以进一步简化
         */
        bt_lambda.setOnClickListener { v ->
            Logger.d("按钮被点击了")
            Logger.d(v.id)
        }
        /**
         * 因为只有一个参数，可以用默认的参数t来代替，因此演变成如下
         */
        bt_lambda.setOnClickListener {
            Logger.d("按钮被点击了")
            Logger.d(it.id)
        }
    }

    override fun initData() {
        test3()
    }

    private fun testMap() {
        /**
         * 再看一个rxjava普通发射int型数据，并用map操作符，转化为string，
         * 如何简化的
         * 可以看到，map参数传入了一个匿名内部类
         */
        Observable.create(ObservableOnSubscribe<Int> {
            it.onNext(1)
        }).map(object : Function<Int, String> {
            override fun apply(integer: Int): String {

                return integer.toString() + "12"
            }
        }).subscribe()
        /**
         * kotlin语法约定，如果对象是单个抽象方法的接口，那么可以用带有
         * 接口类型的前缀的lambda表达式来表示
         */
        Observable.create(ObservableOnSubscribe<Int> {
            it.onNext(1)
        }).map({ index ->
            index.toString() + "12"
        }).subscribe()
        /**
         * kotlin语法约定，如果lambda表达式是函数是最后一个实参的话，它可以放在
         * 括号外面
         */
        Observable.create(ObservableOnSubscribe<Int> {
            it.onNext(1)
        }).map() { index ->
            index.toString() + "12"
        }.subscribe()

        /**
         * kotlin规定，如果lambda是函数的唯一实参的时候
         * 小括号可以直接省略，因此变成这样
         */
        Observable.create(ObservableOnSubscribe<Int> {
            it.onNext(1)
        }).map { index ->
            index.toString() + "12"
        }.subscribe()

        /**
         * 进一步index可以用it表示
         */
        Observable.create(ObservableOnSubscribe<Int> {
            it.onNext(1)
        }).map {

        }.subscribe()

        create { "wodemingzi" }.map {
            Logger.d(this)
            3
        }.map {

            Logger.d(this)
            5
        }
    }

    private fun testInterface() {
        //测试传入java的匿名内部类
        this.setJavaInterface(object : JavaInterface {
            override fun run(age: Int) {

            }
        })
        //可以简化写法，因为setJavaInterface方法是在kotlin 中，所以JavaInterface不可以省略
        this.setJavaInterface(JavaInterface {

        })
        //但是如果因为setJavaInterface方法是在java代码中，接口类型的前缀也可以省略
        JavaSet().setJavaInterface {

        }
        //如果接口中有两个方法，那么就不能省略了。。。
        JavaSet().setJava2Interface(object : JavaInterface2 {
            override fun run(age: Int) {

            }

            override fun stop() {
            }

        })

        //传入kotlin接口的匿名内部类就不可以简化
        this.setKotlinInterface(object : KotlinInterface {
            override fun run(age: Int) {

            }

        })
    }

    fun setJavaInterface(javaListener: JavaInterface) {
        this.javaListener = javaListener
    }

    fun setKotlinInterface(kotlinListener: KotlinInterface) {
        this.kotlinListener = kotlinListener
    }

    private fun test3() {
        /**
         * 第三个参数为一个lambda表达式
         * 类似这个 val sum: (Int, Int) -> Int = { i, j -> i + j }
         */

        ifStringNotNull(null, "hello", { value1, value2 ->
            Logger.d(value1 + value2)
        })
        /**
         * 又因为lambda为第三个参数，因此可以提出去
         */
        ifStringNotNull(null, "hello") { value1, value2 ->
            Logger.d(value1 + value2)
        }
        /**
         * 任意类型的
         */
        ifNotNull(1, "hello") { value1, value2 ->
            Logger.d(value1.toString() + value2)
        }

        val result = ifNotNullString("aa", "bb") { value1, value2 ->
            value1 + value2
        }
        Logger.d(result)
    }

    /**
     *判断两个都不能为空，这里限制了为string
     * lambda具体实现，看调用者
     * @param bothNotNull 方法名
     */
    private fun ifStringNotNull(value1: String?, value2: String?, bothNotNull: (String, String) -> (Unit)) {
        if (value1 != null && value2 != null) {
            bothNotNull(value1, value2)
        }
    }

    //如果不限制类型，可以这样
    private fun <T1, T2> ifNotNull(value1: T1?, value2: T2?, bothNotNull: (T1, T2) -> (Unit)) {
        if (value1 != null && value2 != null) {
            bothNotNull(value1, value2)
        }
    }

    //带返回值的lambda
    private fun <T1, T2> ifNotNullString(value1: T1?, value2: T2?, bothNotNull: (T1, T2) -> (String)): String {
        return if (value1 != null && value2 != null) {
            bothNotNull(value1, value2)
        } else {
            "有一个是空"
        }
    }

}