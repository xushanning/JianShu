package com.xu.module.jianshu.ui.proxy;

import com.orhanobut.logger.Logger;

/**
 * @author 许
 */
public class Hello implements ISayHello {

    @Override
    public String sayHello(String title) {
        Logger.d(title + "你好");
        return "你好调用者";
    }
}
