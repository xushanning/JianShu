package com.xu.module.algorithm;

import android.app.Activity;
import android.util.DisplayMetrics;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class My extends Activity {


    void hello() {
        Person person = new Person();
        IPerson iPerson = (IPerson) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                return null;
            }
        });
        iPerson.run();
    }

    void test() {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float targetDensity = metrics.widthPixels / 360;
        int dpi = (int) targetDensity * 160;
        metrics.density=metrics.scaledDensity=targetDensity;
        metrics.densityDpi=dpi;
    }


}
