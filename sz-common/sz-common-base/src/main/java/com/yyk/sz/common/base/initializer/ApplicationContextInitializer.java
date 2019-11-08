package com.yyk.sz.common.base.initializer;

import com.yyk.sz.common.base.utils.UtilSpringContext;
import com.yyk.sz.common.base.utils.UtilStrSplit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaofs on 2017/4/14
 * 对应用进行初始化
 */
public class ApplicationContextInitializer implements org.springframework.context.ApplicationContextInitializer, Ordered {
    private static final Log logger = LogFactory.getLog(ApplicationContextInitializer.class);

    private int order = Ordered.LOWEST_PRECEDENCE - 11;
    private Map<String, Object> ezdevPropertySourceMap = new HashMap<>();

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        //把Spring上下文注入工具中
        UtilSpringContext.setApplicationContext(applicationContext);

        //初始化默认环境属性
        String applicationName = applicationContext.getEnvironment().getProperty("spring.application.name");
        Class clazz = deduceMainApplicationClass();
        if (applicationName == null && clazz != null) {
            ezdevPropertySourceMap.put("spring.application.name", UtilStrSplit.splitCamelCase(clazz.getSimpleName(), "-"));
        }
        ezdevPropertySourceMap.put("spring.jackson.time-zone", "GMT+8");
        applicationContext.getEnvironment().getPropertySources().addFirst(new MapPropertySource("ezdev_property_source", ezdevPropertySourceMap));
        logger.info("application context environment initialize finished!");
    }

    @Override
    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    private Class<?> deduceMainApplicationClass() {
        try {
            StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if ("main".equals(stackTraceElement.getMethodName())) {
                    return Class.forName(stackTraceElement.getClassName());
                }
            }
        } catch (ClassNotFoundException ex) {
            // Swallow and continue
        }
        return null;
    }

}
