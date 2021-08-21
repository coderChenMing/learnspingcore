package com.learn.thinking.in.spring.ioc.overview.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Project: thinking-in-spring
 * File Created at 2021-08-22 00:11:0:11
 * {@link }
 * @author <a href="mailto:">chenming</a>
 * @version 1.0.0
 * @type Super.java
 * @desc
 * @date 2021/8/22 0022 0:11
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Super {

}
