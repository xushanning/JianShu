package com.xu.module.algorithm;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class My extends Activity {

    private String name = "xuxuxu";


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

    static class MyHandler extends Handler {
        private final WeakReference<My> reference;

        public MyHandler(My activity) {
            reference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            My activity = reference.get();
            if (activity != null) {
                activity.name = "ningningning";
            }
        }
    }

}
