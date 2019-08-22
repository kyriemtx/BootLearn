package com.kyrie.aop.annotation;

import java.lang.annotation.*;

/**
 * @ClassName Log
 * @Description
 * @Author Kyrie
 * @Date 2019/8/22 14:54
 * @Version 1.0
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Log {
    String value() default "";
}
