package com.xu.module.wan;

import android.os.Looper;
import android.os.MessageQueue;

import org.junit.Test;

public class TestPrint {
    private static final int MAX_NUM = 100;
    private static int count = 1;
    private static final Object obj = new Object();

    @Test
    public void printAB() {

        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {
                return false;
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < MAX_NUM) {
                    synchronized (obj) {
                        System.out.println(Thread.currentThread().getName() + count);
                        count++;
                        //立即释放锁
                        obj.notify();

                        try {
                            //调用wait进入等待状态
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "奇数线程").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < MAX_NUM) {
                    synchronized (obj) {
                        System.out.println(Thread.currentThread().getName() + count);
                        count++;
                        //立即释放锁
                        obj.notify();

                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "偶数线程").start();


    }
}
