package com.learn.thinking.in.spring.ioc.overview.domain;

import com.learn.thinking.in.spring.ioc.overview.annotation.Super;

/**
 * Project: thinking-in-spring
 * File Created at 2021-08-22 00:08:0:08
 * {@link }
 * @author <a href="mailto:">chenming</a>
 * @version 1.0.0
 * @type SuperUser.java
 * @desc 超级用户
 * @date 2021/8/22 0022 0:08
 */
@Super
public class SuperUser  extends User {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
