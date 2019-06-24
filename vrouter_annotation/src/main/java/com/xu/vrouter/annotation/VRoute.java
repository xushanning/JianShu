package com.xu.vrouter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 言吾許
 * 路由注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface VRoute {
    /**
     * view的路径
     *
     * @return 路径
     */
    String path();

    /**
     * view的版本 默认为0版本
     *
     * @return 版本
     */
    int version() default 0;
}
