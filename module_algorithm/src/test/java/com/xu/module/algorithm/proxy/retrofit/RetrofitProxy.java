package com.xu.module.algorithm.proxy.retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 言吾許
 * 借此来理解retrofit的动态代理
 * https://www.jianshu.com/p/dcdd286d2e61
 */
public class RetrofitProxy {
    @org.junit.Test
    public void test() {
        IApi iApi = (IApi) Proxy.newProxyInstance(IApi.class.getClassLoader(), new Class<?>[]{IApi.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

//                Integer pageSize = (Integer) args[0];
//                Integer pageNum = (Integer) args[1];
//                System.out.println("参数: " + pageSize + "," + pageNum);
                System.out.println("方法名: " + method.getName());

                Annotation[] annotations = method.getAnnotations();
                System.out.println("注解：" + annotations[0].toString());
                return null;
            }
        });
        iApi.getData(52, 11);
        iApi.postEvent("hello");
    }
}
