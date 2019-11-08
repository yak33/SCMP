package com.yyk.sz.common.base.utils;

import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * Created by zhaofs on 2017/4/19.
 * 以静态变量保存Spring ApplicationContext,方便在Bean容器外获取bean对象
 */
public class UtilSpringContext {
    private static ApplicationContext applicationContext = null;

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

    /**
     * 注册Bean
     *
     * @param beanName      bean名称
     * @param propertyValue bean属性值
     * @param clazz         bean类型
     * @param scope         bean 范围
     * @throws BeanDefinitionStoreException
     */
    public static void registerBean(String beanName, Map<String, Object> propertyValue, Class clazz, String scope) throws BeanDefinitionStoreException {
        registerBean(beanName,propertyValue,clazz,null,null,scope);

    }
    /**
     * 注册Bean
     *
     * @param beanName      bean名称
     * @param propertyValue bean属性值
     * @param clazz         bean类型
     * @param initMethodName bean初始化方法
     * @param destoryMethodName bean销毁方法
     * @param scope         bean 范围 可以为null，则为单例方式
     * @throws BeanDefinitionStoreException
     */
    public static void registerBean(String beanName, Map<String, Object> propertyValue, Class clazz,
                                    String initMethodName,String destoryMethodName, String scope) throws BeanDefinitionStoreException {
        if (applicationContext != null) {
            ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;
            DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) configurableApplicationContext.getBeanFactory();

            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
            if(StringUtils.isEmpty(scope)){//如果为空，默认单例
                scope = ConfigurableBeanFactory.SCOPE_SINGLETON;
            }
            beanDefinitionBuilder.setScope(scope);

            if(!StringUtils.isEmpty(initMethodName)){
                beanDefinitionBuilder.setInitMethodName(initMethodName);
            }

            if(!StringUtils.isEmpty(destoryMethodName)){
                beanDefinitionBuilder.setDestroyMethodName(destoryMethodName);
            }

            // 设置属性值
            for (Map.Entry<String, Object> entry : propertyValue.entrySet()) {
                beanDefinitionBuilder.addPropertyValue(entry.getKey(), entry.getValue());
            }
            defaultListableBeanFactory.registerBeanDefinition(beanName, beanDefinitionBuilder.getRawBeanDefinition());
        } else {
            throw new BeanDefinitionStoreException("application context is null, register bean failed!!!");
        }

    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        UtilSpringContext.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

}
