package com.xu.module.algorithm.proxy;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.xu.module.algorithm.PrintUtil;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 言吾許
 */


public class ProxyTest {
    @org.junit.Test
    public void test() {
        //比如说，这个JavaDeveloper是别人或者第三方的一个类
        JavaDeveloper developer = new JavaDeveloper("xu");
        //第一种实现方式：
        Developer developerProxy = (Developer) Proxy.newProxyInstance(developer.getClass().getClassLoader(), developer.getClass().getInterfaces(), new InvocationHandler() {
            //proxy:代理后的实例对象
            //method:对象被调用的方法
            //args:调用时候的参数
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("code")) {
                    PrintUtil.print("正准备写代码");
                    //执行方法
                    method.invoke(developer, args);
                    return null;
                }
                if (method.getName().equals("debug")) {
                    PrintUtil.print("代码没有bug，不需要debug");
                    //不执行debug方法
                    return null;
                }
                return null;
            }
        });
        developerProxy.code();
        developerProxy.debug();

        //第二种实现方式:不用匿名内部类的话，用这种
//        JavaDeveloper developer2 = new JavaDeveloper("xu");
//        Developer developerProxy2 = (Developer) Proxy.newProxyInstance(developer2.getClass().getClassLoader(), developer2.getClass().getInterfaces(), new JavaProxy(developer2));
//        developerProxy2.code();
//        developerProxy2.debug();

    }
}
