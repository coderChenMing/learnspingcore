package com.learn.ioc.java.beans;

/**
 * Project: java-beans
 * File Created at 2021-08-19 23:18:23:18
 *
 * @author <a href="mailto:">chenming</a>
 * @version 1.0.0
 * @Type Person.java
 * @Desc 描述人的类
 * 贫血模型
 * pojo:setter/getter方法
 * java beans: 称为writable/readable
 * 反射:字段,方法,构造器
 * @date 2021/8/19 0019 23:18
 */
public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
