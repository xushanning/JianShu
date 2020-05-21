package com.xu.module.jianshu.ui.reference

import java.lang.ref.WeakReference

class MyReference {
    fun testWeakReference() {
        val a = A()
        val weak: WeakReference<A> = WeakReference(a)
        val b = weak.get()
        b?.getData()
        System.gc()
    }

    class A {
        fun getData() {

        }
    }
}