package com.learn.thinking.in.spring.ioc.overview.container;

import com.learn.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * Project: thinking-in-spring
 * File Created at 2021-08-30 23:06:23:06
 * {@link org.springframework.context.ApplicationContext}
 *
 * @author <a href="mailto:">chenming</a>
 * @version 1.0.0
 * @type IoCContainerDemo.java
 * @desc 注解IoC容器
 * @date 2021/8/30 0030 23:06
 */
public class AnnotationApplicationContextAsIocContainerDemo {
    public static void main(String[] args) {
        // 定义容器
        // DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类AnnotationApplicationContextAsIocContainerDemo注册到容器,作为配置类
        applicationContext.register(AnnotationApplicationContextAsIocContainerDemo.class);
        // 必须启用上下文
        applicationContext.refresh();
        lookCollectionByType(applicationContext);

    }

    @Bean
    public User getUser() {
        User user = new User();
        user.setId(10L);
        user.setName("哪吒");
        return user;
    }

    private static void lookCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listBeanFactory = (ListableBeanFactory) beanFactory;
            // 返回一个bean id/name作为key 实例作为value的map
            Map<String, User> users = listBeanFactory.getBeansOfType(User.class);
            System.out.println("按照类型实时查找到的所有user对象: " + users);
        }
    }

}
