package com.learn.ioc.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * Project: java-beans
 * File Created at 2021-08-19 23:21:23:21
 * {@link java.beans.BeanInfo} 示例
 *
 * @author <a href="mailto:">chenming</a>
 * @version 1.0.0
 * @Type BeanInfo.java
 * @Desc
 * @date 2021/8/19 0019 23:21
 */
public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException {
        // BeanInfo不是很好理解,通过自省的方式使用
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {
            // 遍历输出
            // 输出内容:属性,读写方法
            // 其中输出超类的getClass方法,可以通过Introspector.getBeanInfo(Person.class,Object.Class);排除
            // spring中应用PropertyDescriptor非常广泛
            System.out.println(propertyDescriptor.toString());
            // 其中一个重要的应用就是通过添加属性编辑器PropertyEditor实现类型转换:比如输入一个Integer类型,输出时是String类型

            String name = propertyDescriptor.getName();
            Class<?> clazz = propertyDescriptor.getPropertyType();
            if ("age".equals(name)) {
                // integer转string,string 转integer
                propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
            }
        });
    }

    static class StringToIntegerPropertyEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws java.lang.IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);

        }
    }
}
