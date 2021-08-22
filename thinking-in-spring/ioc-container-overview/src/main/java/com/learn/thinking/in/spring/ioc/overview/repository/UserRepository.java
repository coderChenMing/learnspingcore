package com.learn.thinking.in.spring.ioc.overview.repository;

import com.learn.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * Project: thinking-in-spring
 * File Created at 2021-08-22 13:07:13:07
 * {@link }
 *
 * @author <a href="mailto:">chenming</a>
 * @version 1.0.0
 * @type UserRepository.java
 * ObjectFactory 通常是针对单类 Bean 做延迟获取的，BeanFactory 则是全局 Bean 管理的容器。
 * @desc 依赖注入, 注入的来源分析
 * @date 2021/8/22 0022 13:07
 */
public class UserRepository {
    // 依赖注入来源于定义bean
    private Collection<User> users;
    /**
     * 来源于内建的非bean对象
     */
    private BeanFactory beanFactory;
    /**
     * private ObjectFactory<user> objectFactory; 延时注入
     * 对比 private ObjectFactory<ApplicationContext> objectFactory

     */
    private ObjectFactory<ApplicationContext> objectFactory;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public ObjectFactory<ApplicationContext> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
        this.objectFactory = objectFactory;
    }
}
