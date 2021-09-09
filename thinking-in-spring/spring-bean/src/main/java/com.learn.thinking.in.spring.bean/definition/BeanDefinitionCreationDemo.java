package com.learn.thinking.in.spring.bean.definition;

import com.learn.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * Project: thinking-in-spring
 * File Created at 2021-09-09 22:32:22:32
 * {@link org.springframework.beans.factory.config.BeanDefinition} 构建实例
 *
 * @author <a href="mailto:">chenming</a>
 * @version 1.0.0
 * @type BeanDefinitionCreationDemo.java
 * @desc
 * @date 2021/9/9 0009 22:32
 */
public class BeanDefinitionCreationDemo {
    public static void main(String[] args) {
        // 1.通过 BeanDefinitionBuilder 创建
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 2.通过属性设置
        builder.addPropertyValue("id", "27");
        builder.addPropertyValue("name", "诸葛亮");
        // 3.获取 BeanDefinition 实例 并非bean的最终状态,后续可以修改
        BeanDefinition beanDefinition = builder.getBeanDefinition();
        System.out.println("--------------------------------------------------");

        // 通过 AbstractBeanDefinition 及其派生类创建 beanDefinition
        GenericBeanDefinition generic = new GenericBeanDefinition();
        // 设置 bean 类型
        generic.setBeanClass(User.class);
        // 通过 MutablePropertyValues 批量操作
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue("id", "26");
        propertyValues.addPropertyValue("name", "刘备");
        generic.setPropertyValues(propertyValues);

    }
}
