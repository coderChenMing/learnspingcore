package com.learn.thinking.in.spring.ioc.overview.dependency.injection;

import com.learn.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * Project: thinking-in-spring
 * File Created at 2021-08-20 00:50:0:50
 * {@link }
 *
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
        // 自定义bean
        UserRepository userRepository = beanFactory.getBean("useRepository", UserRepository.class);
        // 证明依赖查找和依赖注入并不是来自同源
         testBeanFactory(userRepository, beanFactory);

        System.out.println("-------------------------------------------------------------------------");
        ObjectFactory<ApplicationContext> objectFactory = userRepository.getObjectFactory();

        // org.springframework.context.support.ClassPathXmlApplicationContext@1a6c5a9e
        System.out.println(objectFactory.getObject());

        // true
        System.out.println(objectFactory.getObject() == beanFactory);
        // 总结 userRepository.getObjectFactory().getObject() == applicationContext != userRepository.getBeanFactory()

        System.out.println(beanFactory.getBean(Environment.class));
    }

    private static void testBeanFactory(UserRepository userRepository, BeanFactory beanFactory) {
        //userRepository.getUsers().forEach(System.out::println);
        // 依赖注入,注入的beanFactory是内建bean
        // org.springframework.beans.factory.support.DefaultListableBeanFactory@3b81a1bc
        System.out.println(userRepository.getBeanFactory());

        //org.springframework.context.support.ClassPathXmlApplicationContext@1a6c5a9e
        System.out.println(beanFactory);

        // false
        System.out.println(userRepository.getBeanFactory() == beanFactory);
        // 依赖查找(下面这行会报错)
        // BeanFactory.class:容器建立时使用的bean,beanFactory获取不到
        // NoSuchBeanDefinitionException: No qualifying bean of type 'org.springframework.beans.factory.BeanFactory'
        System.out.println(beanFactory.getBean(BeanFactory.class));

    }
}
