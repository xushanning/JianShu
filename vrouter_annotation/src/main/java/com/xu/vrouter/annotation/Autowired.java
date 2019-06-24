package com.xu.vrouter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 言吾許
 * 自动注入
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
public @interface Autowired {
    /**
     * 常量名
     *
     * @return 常量名
     */
    String name() default "";
}