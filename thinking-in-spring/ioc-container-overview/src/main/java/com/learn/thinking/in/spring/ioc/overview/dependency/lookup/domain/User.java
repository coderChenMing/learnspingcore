package com.learn.thinking.in.spring.ioc.overview.dependency.lookup.domain;

/**
 * Project: thinking-in-spring
 * File Created at 2021-08-21 23:33:23:33
 * {@link }
 *
 * @author <a href="mailto:">chenming</a>
 * @version 1.0.0
 * @type User.java
 * @desc
 * @date 2021/8/21 0021 23:33
 */
public class User {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
