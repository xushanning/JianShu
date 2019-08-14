package com.xu.module.algorithm.proxy;

import com.xu.module.algorithm.PrintUtil;

/**
 * @author 言吾許
 * 相当于第三方的一些东西，不能直接修改，或者其他
 */
public class JavaDeveloper implements Developer {
    private String name;

    public JavaDeveloper(String name) {
        this.name = name;
    }

    @Override
    public void code() {
        PrintUtil.print(this.name + " is coding java");
    }

    @Override
    public void debug() {
        PrintUtil.print(this.name + " is debugging java");
    }
}
