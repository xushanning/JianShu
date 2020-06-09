package com.xu.module.jianshu.ui.proxy;

import com.orhanobut.logger.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 许
 */
public class ProxyTest {
    public void testProxy() {
        ISayHello hello = new Hello();
        ISayHello proxyHello = (ISayHello) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Logger.d("你好前");
                //这里invoke的对象一定要传进来，不要用proxy这个第一个参数，会陷入到无限调用里面去
                String res = (String) method.invoke(hello, args);
                Logger.d("你好后");
                return res;
            }
        });
        String res = proxyHello.sayHello("xu");
        Logger.d(res);
    }
}
