package com.xu.module.algorithm.proxy;

import com.xu.module.algorithm.PrintUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 言吾許
 */
public class JavaProxy implements InvocationHandler {
    private Developer developer;

    JavaProxy(Developer developer) {
        this.developer = developer;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //代理逻辑
        if (method.getName().equals("code")) {
            PrintUtil.print("正准备写代码");
            //执行方法
            method.invoke(developer, args);
            PrintUtil.print("代码写完了，可以打游戏了");
            return null;
        }
        if (method.getName().equals("debug")) {
            PrintUtil.print("代码没有bug，不需要debug");
            //不执行debug方法
            return null;
        }
        return null;
    }
}
