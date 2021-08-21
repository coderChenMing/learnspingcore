package com.learn.thinking.in.spring.ioc.overview.dependency.injection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Project: thinking-in-spring
 * File Created at 2021-08-20 00:50:0:50
 * {@link }
 * @author <a href="mailto:">chenming</a>
 * @version 1.0.0
 * @type DependencyLookUpDemo.java
 * @desc 样例
 * 依赖注入:
 * @date 2021/8/20 0020 0:50
 */
public class DependencyInjectDemo {
    public static void main(String[] args) {
        // 创建上下文
        // 配置xml配置文件,启动上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

    }
}
