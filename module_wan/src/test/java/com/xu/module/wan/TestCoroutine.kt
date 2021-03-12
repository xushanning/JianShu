package com.xu.module.wan

import kotlinx.coroutines.*
import org.junit.Test

class TestCoroutine {
    @Test
    fun main() {
        test3()
        print("主线程") // 协程已在等待时主线程还在继续
        Thread.sleep(2000)//保证jvm存活
    }

    //协程启动方式1，此种方式会阻塞线程的。
    private fun test1() = runBlocking {
        print("1")
        //delay(1000)
        launch {
            delay(200)
            print("3")
        }
        coroutineScope {
            launch {
                delay(500L)
                println("4")
            }

            delay(100L)
            println("2")
        }
        println("5")
    }

    //协程启动方式2
    private fun test2() {
        GlobalScope.launch {
            print("协程挂起")
            delay(1000)
            print("挂起函数执行完了")
        }

    }

    private fun test3() {
        print("name1:" + Thread.currentThread().name)
        GlobalScope.launch(Dispatchers.Unconfined) {
            print("name2:" + Thread.currentThread().name)
            val deferred = GlobalScope.async {
                delay(1000L)
                print("name3:" + Thread.currentThread().name)
                print("This is async ")

                return@async "taonce"
            }
            print("协程 other start")

            val result = deferred.await()
            print("async result is $result")
            print("协程 other end ")

        }
    }

}