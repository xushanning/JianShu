package com.xu.module.algorithm.reference;

import com.xu.module.algorithm.PrintUtil;

import java.lang.ref.WeakReference;

public class WeakTest {

    @org.junit.Test
    public void test() {
        Object o1 = new Object();
        WeakReference<Object> weak = new WeakReference<>(o1);
        o1 = null;//置空，对weak不产生影响
        PrintUtil.print(o1);//null
        PrintUtil.print(weak.get());//java.lang.Object@3d012ddd
        System.gc();
        PrintUtil.print(weak.get());//null
    }
}