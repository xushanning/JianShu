package com.xu.module.jianshu.ui.retrofit;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author 言吾許
 */
@Documented
@Target(METHOD)
@Retention(RUNTIME)
public @interface POST {
    String value() default "";
}
