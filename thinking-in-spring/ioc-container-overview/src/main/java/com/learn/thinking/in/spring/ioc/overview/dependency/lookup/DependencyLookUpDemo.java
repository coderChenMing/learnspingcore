package com.learn.thinking.in.spring.ioc.overview.dependency.lookup;

import com.learn.thinking.in.spring.ioc.overview.annotation.Super;
import com.learn.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Project: thinking-in-spring
 * File Created at 2021-08-20 00:50:0:50
 * {@link }
 * @author <a href="mailto:">chenming</a>
 * @version 1.0.0
 * @type DependencyLookUpDemo.java
 * @desc 样例
 * 依赖查找:名称/id 类型  注解  三种方式查找
 * @date 2021/8/20 0020 0:50
 */
public class DependencyLookUpDemo {
    public static void main(String[] args) {
        // 创建上下文
        // 配置xml配置文件,启动上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
        // 延迟查找
        //lookupInLazyTime(beanFactory);
        // 实时查找
        //lookupInRealTime(beanFactory);

        //按照类型查找
        // spring3.0开始支持,java5,支持泛型
        lookUpByType(beanFactory);
        //result:SuperUser{address='shanghai'} User{id=1, name='zhangsan'} 是一个SuperUser对象
        //按照类型查找集合对象
        lookCollectionByType(beanFactory);
        // 通过注解查找
        lookUpByAnno(beanFactory);
    }

    private static void lookUpByAnno(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listBeanFactory = (ListableBeanFactory) beanFactory;
            // 返回一个bean id/name作为key 实例作为value的map
            Map<String, User> users = (Map)listBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("按照注解@super实时查找到的所有user对象: " + users);
        }
    }

    private static void lookCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listBeanFactory = (ListableBeanFactory) beanFactory;
            // 返回一个bean id/name作为key 实例作为value的map
            Map<String, User> users = listBeanFactory.getBeansOfType(User.class);
            System.out.println("按照类型实时查找到的所有user对象: " + users);
        }
    }

    private static void lookUpByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("按照类型实时查找: "+user);
    }

    public static void lookupInRealTime(BeanFactory beanFactory) {
        // spring 3.0之前不支持泛型的
        User user = (User) beanFactory.getBean("user");
        System.out.println("按照姓名/id实时查找: "+user);
    }

    public static void lookupInLazyTime(BeanFactory beanFactory) {
        // spring 3.0之前不支持泛型的
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactoryCreatingFactoryBean");
        User user = objectFactory.getObject();
        System.out.println("按照姓名/id延时查找: "+user);

    }

}
