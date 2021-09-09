package com.learn.thinking.in.spring.ioc.overview.container;

import com.learn.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * Project: thinking-in-spring
 * File Created at 2021-08-30 23:06:23:06
 * {@link BeanFactory}
 *
 * @author <a href="mailto:">chenming</a>
 * @version 1.0.0
 * @type IoCContainerDemo.java
 * @desc 使用默认Ioc容器
 * @date 2021/8/30 0030 23:06
 */
public class BeanFactoryAsIocContainerDemo {
    public static void main(String[] args) {
        // 定义容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 读取xml配置 DefaultListableBeanFactory impl BeanDefinitionRegistry
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        // 定义配置文件路径
        String location = "classpath:/META-INF/dependency-lookup-context.xml";
       // 读取配置文件
        int beanDefinitionsCount = reader.loadBeanDefinitions(location);
        System.out.println(" Bean 定义加载的数量: " + beanDefinitionsCount);
        lookCollectionByType(beanFactory);

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
