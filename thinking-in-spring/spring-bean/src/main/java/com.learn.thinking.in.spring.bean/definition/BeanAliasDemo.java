package com.learn.thinking.in.spring.bean.definition;

import com.learn.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Project: thinking-in-spring
 * File Created at 2021-09-09 23:14:23:14
 * {@link }
 * @author <a href="mailto:">chenming</a>
 * @version 1.0.0
 * @type AliasDemo.java
 * @desc
 * @date 2021/9/9 0009 23:14
 */
public class BeanAliasDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");
        // 通过别名get
        User user = beanFactory.getBean("user", User.class);
        User zhangsan = beanFactory.getBean("zhangsan-user", User.class);
        // true
        System.out.println(user==zhangsan);

    }
}
