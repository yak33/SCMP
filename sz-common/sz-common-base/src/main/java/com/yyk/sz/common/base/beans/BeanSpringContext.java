package com.yyk.sz.common.base.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanSpringContext implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanSpringContext.applicationContext = applicationContext;
    }


    /**
     * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
     *
     * @param name Bean名称
     * @param <T>  Bean类型
     * @return Bean
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        return applicationContext == null ? null : (T) applicationContext.getBean(name);
    }


    /**
     * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
     *
     * @param requiredType Bean类型
     * @param <T>          Bean类型
     * @return
     */
    public static <T> T getBean(Class<T> requiredType) {
        return applicationContext == null ? null : applicationContext.getBean(requiredType);
    }
}
